package com.qing.controller;

import com.qing.constants.SystemConstants;
import com.qing.entity.Article;
import com.qing.entity.ResponseResult;
import com.qing.service.ArticleService;
import com.qing.utils.RedisCache;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @Resource
    private RedisCache redisCache;

    @GetMapping("/list")
    public List<Article> list(){
        List<Article> list = articleService.list();
        return list;
    }

    //查询热门文章接口
    @GetMapping("/hotArticleList")
    public ResponseResult hotArticleList(){
        ResponseResult result = articleService.hotArticleList();
        return result;
    }

    @GetMapping("/articleList")
    public ResponseResult articleList(Integer pageNum,Integer pageSize,Long categoryId){

       return articleService.articleList(pageNum,pageSize,categoryId);
    }

    @GetMapping("/{id}")
    public ResponseResult getArticleDetail(@PathVariable("id") Long id){

       return articleService.getArticleDetail(id);
    }
    //更新博客浏览量
    @PutMapping("/updateViewCount/{id}")
    public ResponseResult updateViewCount(@PathVariable("id") Long id){
        redisCache.incrementCacheMapValue(SystemConstants.ARTICLE_VIEWCOUNT,id.toString(),1);
        return ResponseResult.okResult();
    }

}
