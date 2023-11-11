package com.qing.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qing.entity.ResponseResult;
import com.qing.entity.Role;
import com.qing.vo.PageVo;
import com.qing.vo.RoleStatusVo;

import java.util.List;


/**
 * 角色信息表(Role)表服务接口
 *
 * @author makejava
 * @since 2023-08-08 14:19:40
 */
public interface RoleService extends IService<Role> {

    List<String> selectRoleKeyByUserId(Long userId);

    ResponseResult<PageVo> roleList(Integer pageNum, Integer pageSize, String roleName, String status);

    ResponseResult changeStatus(RoleStatusVo roleStatusVo);

    ResponseResult selectRoleById(Long id);

    ResponseResult updateRole(Role role);
}
