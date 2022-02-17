package com.wubo.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wubo.blog.pojo.article;
import com.wubo.blog.pojo.category;

import java.util.List;

public interface categoryDao extends BaseMapper<category> {
    public List<article> selectByIdArticle(String id);
}
