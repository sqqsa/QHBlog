package com.qing.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qing.entity.Role;

import java.util.List;

/**
 * 角色信息表(Role)表数据库访问层
 *
 * @author makejava
 * @since 2023-08-08 14:19:38
 */
public interface RoleMapper extends BaseMapper<Role> {

    List<String> selectRoleKeyByUserId(Long userId);
}

