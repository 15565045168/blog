package com.wubo.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wubo.blog.dao.categoryDao;
import com.wubo.blog.pojo.article;
import com.wubo.blog.pojo.category;
import com.wubo.blog.service.categoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class categoryServiceImpl implements categoryService {
    @Autowired
    private categoryDao cd;

    @Override
    public List<category> selectAll() {
        List<category> categories = cd.selectList(new QueryWrapper<>());
        return categories;
    }

    @Override
    public List<article> selectByIdarticle(String id) {
        List<article> articles = cd.selectByIdArticle(id);
        return articles;
    }

    @Override
    public boolean addCategory(category category) {
        int insert = cd.insert(category);
        return insert>0;
    }

}
