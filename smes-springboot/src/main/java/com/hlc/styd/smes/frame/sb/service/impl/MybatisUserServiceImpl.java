package com.hlc.styd.smes.frame.sb.service.impl;

import com.hlc.styd.smes.frame.sb.dao.mybatis.UserMapper;
import com.hlc.styd.smes.frame.sb.entity.Db_User;
import com.hlc.styd.smes.frame.sb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Liang on 2018/11/28.
 */
@Service("mybatisUserService")
public class MybatisUserServiceImpl implements IUserService<Db_User> {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void save(Db_User user) {
        userMapper.insert(user);
    }

    @Override
    public void update(Db_User user) {
        userMapper.update(user);
    }

    @Override
    public void delete(Db_User user) {
        userMapper.deleteByKey(user.getId());
    }

    @Override
    public int count(Db_User user) {
        return userMapper.count(user);
    }

    @Override
    public List<Db_User> findAll() {
        return userMapper.selectAll();
    }

    @Override
    public Db_User findById(Integer id) {
        return userMapper.selectByKey(id);
    }

    @Override
    public List<Db_User> findByCriteria(Db_User user) {
        return null;
    }

    @Override
    public List<Db_User> findByPage(int pageindex, int pagesize, Db_User user) {
        HashMap<String,Object> param =new HashMap<String,Object>();
        param.put("pageindex",pageindex);
        param.put("pagesize",pagesize);
        return userMapper.selectByPage(param);
    }
}
