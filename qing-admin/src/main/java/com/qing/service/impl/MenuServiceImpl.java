package com.qing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qing.constants.SystemConstants;
import com.qing.entity.ResponseResult;
import com.qing.entity.Tag;
import com.qing.enums.AppHttpCodeEnum;
import com.qing.exception.SystemException;
import com.qing.utils.SecurityUtils;
import com.qing.vo.RoutersVo;
import org.springframework.stereotype.Service;
import com.qing.entity.Menu;
import com.qing.mapper.MenuMapper;
import com.qing.service.MenuService;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 菜单权限表(Menu)表服务实现类
 *
 * @author makejava
 * @since 2023-08-08 14:21:34
 */
@Service("menuService")
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Resource
    private MenuMapper menuMapper;


    @Override
    public List<String> selectPermsByUserId(Long userId) {
        //如果是管理员，返回所有的权限
        if (SecurityUtils.isAdmin()){
            LambdaQueryWrapper<Menu> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.in(Menu::getMenuType, SystemConstants.MENU,SystemConstants.BUTTON);
            queryWrapper.eq(Menu::getStatus,SystemConstants.STATUS_NORMAL);
            List<Menu> menus = menuMapper.selectList(queryWrapper);
            List<String> perms = menus.stream()
                    .map(Menu::getPerms)
                    .collect(Collectors.toList());
            return perms;
        }
        //否则返回角色所具有的权限
        return menuMapper.selectPermsByUserId(userId);
    }

    @Override
    public List<Menu> selectRouterMenuTreeByUserId(Long userId) {
        //判断是否是管理员
        List<Menu> menus = null;
        if (SecurityUtils.isAdmin()){
        //如果是管理员，返回所有符合要求的菜单menu
           menus =  menuMapper.selectAllRouterMenu();
        }else {
            menus = menuMapper.selectRouterMenuByUserId(userId);
        }
        //构建tree
        //先找出第一层的菜单  然后去找他们的子菜单设置到children属性中
        List<Menu> menuTree = builderMenuTree(menus,0L);
        return menuTree;
    }
    //分页查询菜单
    @Override
    public ResponseResult menuList(String status, String menuName) {

        LambdaQueryWrapper<Menu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(Menu::getStatus,status);
        queryWrapper.like(Menu::getMenuName,menuName);
        queryWrapper.orderByDesc(Menu::getParentId);
        queryWrapper.orderByAsc(Menu::getOrderNum);

        List<Menu> menus = menuMapper.selectList(queryWrapper);
        for (Menu menu: menus) {
            List<Menu> children = getChildren(menu, menus);
            menu.setChildren(children);

        }
        return ResponseResult.okResult(menus);
    }

    //添加菜单
    @Override
    public ResponseResult saveMenu(Menu menu) {

        if (menuNameExist(menu.getMenuName())){
            throw new SystemException(AppHttpCodeEnum.MENUNAME_EXIST);
        }
        if (menuComponentExist(menu.getComponent())){
            throw new SystemException(AppHttpCodeEnum.MENUCOMPONENT_EXIST);
        }
        if (menuIconExist(menu.getIcon())){
            throw new SystemException(AppHttpCodeEnum.MENUICON_EXIST);
        }
        save(menu);
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult selectMenuById(Long id) {
        LambdaQueryWrapper<Menu> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapper.eq(Menu::getId,id);
        Menu menu = menuMapper.selectOne(queryWrapper);
        return ResponseResult.okResult(menu);
    }

    @Override
    public ResponseResult updateMenu(Menu menu) {

        if (menu.getParentId() == menu.getId()){
            throw new SystemException(AppHttpCodeEnum.MENUNAME_ERROR);
        }
        menuMapper.updateById(menu);
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult<RoutersVo> roleMenuTreeSelect(Long id) {

        List<Menu> menus = selectRouterMenuTreeByUserId(id);
        for (Menu menu: menus) {
            List<Menu> children = getChildren(menu, menus);
            menu.setChildren(children);

        }
        return ResponseResult.okResult(menus);

    }

    @Override
    public ResponseResult deleteMenuById(Long id) {

        LambdaUpdateWrapper<Menu> queryWrapper = new LambdaUpdateWrapper<>();

        queryWrapper.eq(Menu::getId,id);
        queryWrapper.set(Menu::getDelFlag,SystemConstants.DEL_FLAG);

        update(queryWrapper);

        return ResponseResult.okResult();

    }
    //树化菜单
    private List<Menu> builderMenuTree(List<Menu> menus, long parentId) {
        List<Menu> menuTree = menus.stream()
                .filter(menu -> menu.getParentId().equals(parentId))
                .map(menu -> menu.setChildren(getChildren(menu, menus)))
                .collect(Collectors.toList());
        return menuTree;
    }

    /**
     * 获取存入参数的 子Menu集合
     * @param menu
     * @param menus
     * @return
     */
    private List<Menu> getChildren(Menu menu, List<Menu> menus) {
        List<Menu> childrenList = menus.stream()
                .filter(m -> m.getParentId().equals(menu.getId()))
                .map(m -> m.setChildren(getChildren(m, menus)))
                .collect(Collectors.toList());

        return childrenList;
    }

    //菜单名是否已经存在
    private boolean menuNameExist(String name) {
        LambdaQueryWrapper<Menu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Menu::getMenuName,name);

        Integer count = menuMapper.selectCount(queryWrapper);
        return count > 0;
    }
    //菜单路径是否已经存在
    private boolean menuComponentExist(String component) {
        LambdaQueryWrapper<Menu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Menu::getComponent,component);

        Integer count = menuMapper.selectCount(queryWrapper);
        return count > 0;
    }
    //菜单图标是否已经存在
    private boolean menuIconExist(String icon) {
        LambdaQueryWrapper<Menu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Menu::getIcon,icon);

        Integer count = menuMapper.selectCount(queryWrapper);
        return count > 0;
    }
}
