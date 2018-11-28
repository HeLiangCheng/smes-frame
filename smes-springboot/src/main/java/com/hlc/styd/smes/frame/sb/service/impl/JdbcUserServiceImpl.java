package com.hlc.styd.smes.frame.sb.service.impl;

import com.hlc.styd.smes.frame.sb.dao.jdbc.IUserDao;
import com.hlc.styd.smes.frame.sb.entity.Db_User;
import com.hlc.styd.smes.frame.sb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Liang on 2018/11/28.
 */
@Service("jdbcUserService")
public class JdbcUserServiceImpl implements IUserService<Db_User> {

    @Autowired
    private IUserDao userDao;

    @Override
    public void save(Db_User user) {
        userDao.save(user);
    }

    @Override
    public void update(Db_User user) {
        userDao.update(user);
    }

    @Override
    public void delete(Db_User user) {
        userDao.delete(user);
    }

    @Override
    public int count(Db_User user) {
        return  userDao.count(user);
    }

    @Override
    public List<Db_User> findAll() {
        return userDao.findAll();
    }

    @Override
    public Db_User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public List<Db_User> findByCriteria(Db_User user) {
        return userDao.findByCriteria(user);
    }

    @Override
    public List<Db_User> findByPage(int pageindex, int pagesize, Db_User user) {
        return userDao.findByPage(pageindex, pagesize, user);
    }
}
