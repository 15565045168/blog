package com.wubo.blog.service;

import com.wubo.blog.pojo.user;

public interface userService {
    public user selectUsername(String id);

    Boolean register(user user);

    boolean update(user user);

    boolean deleteById(String id);

    user login(String username, String password);
    int selectUserName(String username);
}
