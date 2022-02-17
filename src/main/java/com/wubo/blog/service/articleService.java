package com.wubo.blog.service;

import com.wubo.blog.pojo.article;

import java.util.List;

public interface articleService {
    boolean addArticle(article article);

    List<article> selectArticleTime();

    List<article> selectTitleVague(String title);
}
