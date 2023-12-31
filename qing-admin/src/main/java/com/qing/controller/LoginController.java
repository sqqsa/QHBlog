package com.qing.controller;


import com.qing.entity.Menu;
import com.qing.entity.ResponseResult;
import com.qing.entity.User;
import com.qing.enums.AppHttpCodeEnum;
import com.qing.exception.SystemException;
import com.qing.service.LoginService;
import com.qing.service.MenuService;
import com.qing.service.RoleService;
import com.qing.utils.SecurityUtils;
import com.qing.vo.AdminUserInfoVo;
import com.qing.vo.RoutersVo;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController

public class LoginController {

    @Resource
    private LoginService loginService;

    @Resource
    private MenuService menuService;

    @Resource
    private RoleService roleService;


    @PostMapping("/user/login")
    public ResponseResult Login(@RequestBody User user){
        if(!StringUtils.hasText(user.getUserName())) {
            //提示 必须要传用户名
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        return loginService.login(user);
    }

    @PostMapping("/user/logout")
    public ResponseResult logout(){
        return loginService.logout();
    }

    @GetMapping("getInfo")
    public ResponseResult<AdminUserInfoVo> getInfo(){

        return ResponseResult.okResult(loginService.getInfo());


    }
//    @GetMapping("getInfo")
//    public ResponseResult<AdminUserInfoVo> getInfo(){
//        //获取当前登录的用户
//        LoginUser loginUser = SecurityUtils.getLoginUser();
//        //根据用户id查询权限信息
//        List<String> perms = menuService.selectPermsByUserId(loginUser.getUser().getId());
//        //根据用户id查询角色信息
//        List<String> roleKeyList = roleService.selectRoleKeyByUserId(loginUser.getUser().getId());
//
//        //获取用户信息
//        User user = loginUser.getUser();
//        UserInfoVo userInfoVo = BeanCopyUtils.copyBean(user, UserInfoVo.class);
//        //封装数据返回
//
//        AdminUserInfoVo adminUserInfoVo = new AdminUserInfoVo(perms,roleKeyList,userInfoVo);
//        return ResponseResult.okResult(adminUserInfoVo);
//    }


    @GetMapping("getRouters")
    public ResponseResult<RoutersVo> getRouters(){
        Long userId = SecurityUtils.getUserId();
        //查询menu 结果是tree的形式
        List<Menu> menus = menuService.selectRouterMenuTreeByUserId(userId);
        //封装数据返回
        return ResponseResult.okResult(new RoutersVo(menus));
    }

}
