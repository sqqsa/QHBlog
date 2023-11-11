package com.qing.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qing.dto.AddArticleDto;
import com.qing.entity.Article;
import com.qing.entity.ResponseResult;
import com.qing.vo.PageVo;

public interface ArticleService extends IService<Article> {
    ResponseResult hotArticleList();


    ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId);

    ResponseResult getArticleDetail(Long id);

    ResponseResult add(AddArticleDto article);

    ResponseResult<PageVo> queryArticleList(Integer pageNum, Integer pageSize, String title, String summary);

    ResponseResult selectArticleById(Long id);

    ResponseResult deleteArticleById(Long id);

    ResponseResult updateArticle(AddArticleDto articleDto);
}
