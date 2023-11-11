package com.qing.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.qing.entity.ResponseResult;
import com.qing.entity.User;

public interface BlogLoginService extends IService<User> {
    ResponseResult login(User user);

    ResponseResult logout();
}
