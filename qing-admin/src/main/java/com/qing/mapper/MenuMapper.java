package com.qing.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qing.entity.Menu;

import java.util.List;

/**
 * 菜单权限表(Menu)表数据库访问层
 *
 * @author makejava
 * @since 2023-08-08 14:21:30
 */
public interface MenuMapper extends BaseMapper<Menu> {


    //根据用户id查询菜单
    List<String> selectPermsByUserId(Long userId);

    List<Menu> selectAllRouterMenu();

    List<Menu> selectRouterMenuByUserId(Long userId);
}

