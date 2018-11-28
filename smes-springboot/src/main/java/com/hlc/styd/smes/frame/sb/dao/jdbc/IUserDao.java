package com.hlc.styd.smes.frame.sb.dao.jdbc;

import com.hlc.styd.smes.frame.sb.entity.Db_User;
import com.mongodb.DB;

import java.util.List;

/**
 * Created by Liang on 2018/11/27.
 */
public interface IUserDao {

    void save(Db_User user);

    void update(Db_User user);

    void delete(Db_User user);

    int count(Db_User user);

    List<Db_User> findAll();

    Db_User findById(Integer id);

    List<Db_User> findByCriteria(Db_User user);

    List<Db_User> findByPage(int pageindex,int pagesize,Db_User user);

}
