package com.hlc.styd.smes.web.service.impl;

import com.hlc.styd.smes.web.dao.IUserDao;
import com.hlc.styd.smes.web.entity.User;
import com.hlc.styd.smes.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Liang on 2018/11/21.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private IUserDao userDao;

    public int saveorupdate(User user) {
        int result = -1;
        if (user.getId() == null) {
            result = userDao.save(user);
        } else {
            result = userDao.update(user);
        }
        return result;
    }

    public int deleteUser(int id) {
        return userDao.delete(id);
    }

    public User findById(int id) {
        return userDao.selectByKey(id);
    }

    public List<User> findByUser(User user) {
        return userDao.selectList(user);
    }

    public int count(User user) {
        return userDao.count(user);
    }

}
