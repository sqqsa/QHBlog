package com.qing.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qing.entity.ResponseResult;
import com.qing.entity.User;
import com.qing.vo.AdminUserInfoVo;

public interface LoginService extends IService<User> {
    ResponseResult login(User user);

    ResponseResult logout();

    AdminUserInfoVo getInfo();
}
