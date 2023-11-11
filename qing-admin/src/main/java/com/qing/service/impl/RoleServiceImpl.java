package com.qing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qing.entity.Menu;
import com.qing.entity.ResponseResult;
import com.qing.entity.Tag;
import com.qing.mapper.RoleMapper;
import com.qing.service.RoleService;
import com.qing.vo.PageVo;
import com.qing.vo.RoleStatusVo;
import org.springframework.stereotype.Service;
import com.qing.entity.Role;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * 角色信息表(Role)表服务实现类
 *
 * @author makejava
 * @since 2023-08-08 14:19:40
 */
@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<String> selectRoleKeyByUserId(Long userId) {
        //如果为管理员
        if (userId == 1L){
            List<String> roleKey = new ArrayList<>();
            roleKey.add("admin");
            return roleKey;
        }
        //如果不是管理员
        return roleMapper.selectRoleKeyByUserId(userId);
    }

    @Override
    public ResponseResult<PageVo> roleList(Integer pageNum, Integer pageSize, String roleName, String status) {
        //模糊查询
        LambdaQueryWrapper<Role> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(Role::getRoleName,roleName);
        queryWrapper.like(Role::getStatus,status);
        queryWrapper.orderByAsc(Role::getRoleSort);

        //分页查询
        Page<Role> page = new Page<>();
        page(page,queryWrapper);

        //封装
        PageVo pageVo = new PageVo(page.getRecords(),page.getTotal());

        return ResponseResult.okResult(pageVo);

    }

    @Override
    public ResponseResult changeStatus(RoleStatusVo roleStatusVo) {

        Role role = new Role();
        role.setId(roleStatusVo.getRoleId());
        role.setStatus(roleStatusVo.getStatus());

        roleMapper.updateById(role);
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult selectRoleById(Long id) {
        LambdaQueryWrapper<Role> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Role::getId,id);
        Role role = roleMapper.selectOne(queryWrapper);
        return ResponseResult.okResult(role);
    }

    @Override
    public ResponseResult updateRole(Role role) {
        roleMapper.updateById(role);
        return ResponseResult.okResult();
    }

}
