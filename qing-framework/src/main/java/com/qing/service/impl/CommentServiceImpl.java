package com.qing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qing.constants.SystemConstants;
import com.qing.entity.ResponseResult;
import com.qing.enums.AppHttpCodeEnum;
import com.qing.exception.SystemException;
import com.qing.service.UserService;
import com.qing.utils.BeanCopyUtils;
import com.qing.vo.CommentVo;
import com.qing.vo.PageVo;
import org.springframework.stereotype.Service;
import com.qing.entity.Comment;
import com.qing.mapper.CommentMapper;
import com.qing.service.CommentService;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 评论表(Comment)表服务实现类
 *
 * @author makejava
 * @since 2023-07-29 15:22:38
 */
@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Resource
    private UserService userService;

    @Override
    public ResponseResult commentList(String commentType,Long articleId, Integer pageNum, Integer pageSize) {

        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper<>();

        //对articleId进行判断
        queryWrapper.eq(SystemConstants.ARTICLE_COMMENT.equals(commentType),Comment::getArticleId,articleId);

        //查询评论类型
        queryWrapper.eq(Comment::getType,commentType);
        //查询根评论
        queryWrapper.eq(Comment::getRootId, SystemConstants.COMMENT_STATUS_ROOT);

        //分页查询
        Page<Comment> page = new Page<>(pageNum,pageSize);
        page(page,queryWrapper);

        //封装
        List<CommentVo> commentVos = toCommentVoList(page.getRecords());

        for (CommentVo commentVo:commentVos) {
            List<CommentVo> children = getChildren(commentVo.getId());

            commentVo.setChildren(children);
        }

        return ResponseResult.okResult(new PageVo(commentVos,page.getTotal()));
    }

    //发布评论
    @Override
    public ResponseResult addComment(Comment comment) {
        //评论不能为空
        if (!StringUtils.hasText(comment.getContent())){
            throw new SystemException(AppHttpCodeEnum.CONTENT_NOT_NULL);
        }
        commentMapper.insert(comment);
        return ResponseResult.okResult();
    }

    /**
     * 根据根评论的id查询所对应的子评论的集合
     * @param id 根评论的id
     * @return
     */
    private List<CommentVo> getChildren(Long id){
        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Comment::getRootId,id);
        queryWrapper.orderByAsc(Comment::getCreateTime);
        List<Comment> comments = commentMapper.selectList(queryWrapper);

        List<CommentVo> commentVos = toCommentVoList(comments);

        return commentVos;
    }


    private List<CommentVo> toCommentVoList(List<Comment> list){
        List<CommentVo> commentVos = BeanCopyUtils.copyBeanList(list, CommentVo.class);

        for (CommentVo commentVo:commentVos) {
            //通过CreateBy查询用户的昵称并赋值
            String nickName = userService.getById(commentVo.getCreateBy()).getNickName();
            commentVo.setUsername(nickName);
            //通过toCommentUserId查询用户的昵称并赋值
            //如果toCommentUserId不为-1才进行查询
            if (commentVo.getToCommentId() != -1){
                String toCommentUserName = userService.getById(commentVo.getToCommentUserId()).getNickName();
                commentVo.setToCommentUserName(toCommentUserName);
            }

        }
        return commentVos;
    }
}
