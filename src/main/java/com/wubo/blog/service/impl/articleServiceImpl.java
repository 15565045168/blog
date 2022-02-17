package com.wubo.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wubo.blog.dao.articleDao;
import com.wubo.blog.pojo.article;
import com.wubo.blog.service.articleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class articleServiceImpl implements articleService {
   @Autowired
    private articleDao ad;

    @Override
    public boolean addArticle(article article) {
        int insert = ad.insert(article);
        return insert>0;
    }

    @Override
    public List<article> selectArticleTime() {
        QueryWrapper<article> query=new QueryWrapper<>();
        query.orderByDesc("create_time");
        List<article> articles = ad.selectList(query);
        return articles;
    }

    @Override
    public List<article> selectTitleVague(String title) {
        QueryWrapper<article> query=new QueryWrapper<>();
        query.like("title","%"+title+"%");
        query.orderByDesc("create_time");
        List<article> articles = ad.selectList(query);
        return articles;
    }
}
