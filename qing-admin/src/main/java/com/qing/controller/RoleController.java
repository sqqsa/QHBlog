package com.qing.controller;

import com.qing.entity.ResponseResult;
import com.qing.entity.Role;
import com.qing.service.RoleService;
import com.qing.vo.PageVo;
import com.qing.vo.RoleStatusVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/system/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    @GetMapping("/list")
    public ResponseResult<PageVo> list(@RequestParam Integer pageNum,
                                       @RequestParam Integer pageSize,
                                       @RequestParam(defaultValue = "") String roleName,
                                       @RequestParam(defaultValue = "") String status){
        return roleService.roleList(pageNum,pageSize,roleName,status);
    }

    //根据id查询权限
    @GetMapping("/{id}")
    public ResponseResult selectRoleById(@PathVariable Long id){

        return roleService.selectRoleById(id);
    }

    @PutMapping("/changeStatus")
    public ResponseResult changeStatus(@RequestBody RoleStatusVo roleStatusVo){

        return roleService.changeStatus(roleStatusVo);
    }

    @PutMapping()
    public ResponseResult updateRole(@RequestBody Role role){
        return roleService.updateRole(role);
    }
}
