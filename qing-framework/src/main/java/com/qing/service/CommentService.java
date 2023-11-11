package com.qing.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qing.entity.Comment;
import com.qing.entity.ResponseResult;


/**
 * 评论表(Comment)表服务接口
 *
 * @author makejava
 * @since 2023-07-29 15:22:38
 */
public interface CommentService extends IService<Comment> {

    ResponseResult commentList(String commentType,Long articleId, Integer pageNum, Integer pageSize);

    ResponseResult addComment(Comment comment);
}
