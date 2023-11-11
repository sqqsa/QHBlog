package com.qing.controller;

import com.qing.dto.AddArticleDto;
import com.qing.entity.ResponseResult;
import com.qing.service.ArticleService;
import com.qing.vo.PageVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/content/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    //文章分页列表
    @GetMapping("/list")
    public ResponseResult<PageVo> list(@RequestParam Integer pageNum,
                                       @RequestParam Integer pageSize,
                                       @RequestParam(defaultValue = "") String title,
                                       @RequestParam(defaultValue = "") String summary){
        return articleService.queryArticleList(pageNum,pageSize,title,summary);
    }

    //发布文章
    @PostMapping
    public ResponseResult add(@RequestBody AddArticleDto article){

        return articleService.add(article);
    }

    //根据id查询文章
    @GetMapping("{id}")
    public ResponseResult selectArticleById(@PathVariable Long id){
        return articleService.selectArticleById(id);
    }


    //修改文章
    @PutMapping()
    public ResponseResult updateArticle(@RequestBody AddArticleDto article){
        return articleService.updateArticle(article);
    }
    //删除文章
    @DeleteMapping("{id}")
    public ResponseResult deleteArticleById(@PathVariable Long id){
        return articleService.deleteArticleById(id);
    }



}