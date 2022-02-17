package com.wubo.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wubo.blog.pojo.user;

public interface userdao extends BaseMapper<user>{
    boolean updated(user user);
}
