package com.wubo.blog.service;

import com.wubo.blog.pojo.article;
import com.wubo.blog.pojo.category;

import java.util.List;

public interface categoryService {
    List<category> selectAll();

    List<article> selectByIdarticle(String id);

    boolean addCategory(category category);
}
