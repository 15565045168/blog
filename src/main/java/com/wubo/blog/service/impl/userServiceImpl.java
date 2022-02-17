package com.wubo.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.wubo.blog.dao.userdao;
import com.wubo.blog.pojo.user;
import com.wubo.blog.service.userService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class userServiceImpl implements userService {
    @Resource
    private userdao ud;

    @Override
    public user selectUsername(String id) {
        user user = ud.selectById(id);
        return user;
    }

    @Override
    public Boolean register(user user) {
        int insert = ud.insert(user);
        return insert>0;
    }

    @Override
    public boolean update(user user) {
        UpdateWrapper<user> us=new UpdateWrapper();
        us.eq("id",user.getId());
        user.setUpdateTime(new Date());
        int update = ud.update(user, us);
        return update>0;
    }

    @Override
    public boolean deleteById(String id) {
        int i = ud.deleteById(id);
        return i>0;
    }

    @Override
    public user login(String username, String password) {
        QueryWrapper<user> query=new QueryWrapper<>();
        query.eq("username",username);
        query.eq("password",password);
        user user = ud.selectOne(query);
        return user;
    }

    @Override
    public int selectUserName(String username) {
        QueryWrapper<user> query=new QueryWrapper<>();
        query.eq("username",username);
        Integer integer = ud.selectCount(query);
        return integer;
    }
}
