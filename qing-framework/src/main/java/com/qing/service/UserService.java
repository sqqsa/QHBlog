package com.qing.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qing.entity.ResponseResult;
import com.qing.entity.User;


/**
 * 用户表(User)表服务接口
 *
 * @author makejava
 * @since 2023-07-29 15:59:01
 */
public interface UserService extends IService<User> {

    ResponseResult userInfo();

    ResponseResult updateUserInfo(User user);

    ResponseResult register(User user);
}
