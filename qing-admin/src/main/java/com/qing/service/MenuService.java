package com.qing.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qing.entity.Menu;
import com.qing.entity.ResponseResult;
import com.qing.vo.RoutersVo;

import java.util.List;


/**
 * 菜单权限表(Menu)表服务接口
 *
 * @author makejava
 * @since 2023-08-08 14:21:33
 */
public interface MenuService extends IService<Menu> {



    ResponseResult deleteMenuById(Long id);

    List<String> selectPermsByUserId(Long userId);

    List<Menu> selectRouterMenuTreeByUserId(Long userId);

    ResponseResult<RoutersVo> menuList(String status, String menuName);

    ResponseResult saveMenu(Menu menu);

    ResponseResult selectMenuById(Long id);

    ResponseResult updateMenu(Menu menu);

    ResponseResult<RoutersVo> roleMenuTreeSelect(Long id);
//    List<Menu> menuList(String status, String menuName);
}
