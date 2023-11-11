package com.qing.runner;

import com.qing.constants.SystemConstants;
import com.qing.entity.Article;
import com.qing.mapper.ArticleMapper;
import com.qing.utils.RedisCache;
import io.lettuce.core.dynamic.annotation.CommandNaming;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class ViewCountRunner implements CommandLineRunner {
    
    @Resource
    private ArticleMapper articleMapper;

    @Resource
    private RedisCache redisCache;
    @Override
    public void run(String... args) throws Exception {
        //查询博客信息 id viewCount
        List<Article> articles = articleMapper.selectList(null);
        //id做key viewCount做值
        Map<String, Integer> viewCountMap = articles.stream()
                .collect(Collectors.toMap(article -> article.getId().toString(), article -> article.getViewCount().intValue()));

        //存入redis
        redisCache.setCacheMap(SystemConstants.ARTICLE_VIEWCOUNT,viewCountMap);
    }
}
