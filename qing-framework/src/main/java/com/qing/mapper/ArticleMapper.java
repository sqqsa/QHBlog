package com.qing.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qing.entity.Article;

import java.util.List;

public interface ArticleMapper extends BaseMapper<Article> {

    List<Article> findHotArticleList();
}
