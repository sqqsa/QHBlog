package com.qing.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qing.entity.Link;
import com.qing.entity.ResponseResult;


/**
 * 友链(Link)表服务接口
 *
 * @author makejava
 * @since 2023-07-27 16:26:05
 */
public interface LinkService extends IService<Link> {

    ResponseResult getAllLink();
}
