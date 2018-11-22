package com.hlc.styd.smes.web.service;

import com.hlc.styd.smes.web.entity.User;

import java.util.List;

/**
 * Created by Liang on 2018/11/21.
 */
public interface UserService {

    int saveorupdate(User user);

    int deleteUser(int id);

    User findById(int id);

    List<User> findByUser(User user);

    int count(User user);
}
