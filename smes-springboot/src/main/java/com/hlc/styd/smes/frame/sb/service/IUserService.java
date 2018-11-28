package com.hlc.styd.smes.frame.sb.service;

import com.hlc.styd.smes.frame.sb.entity.Db_User;

import java.util.List;

/**
 * Created by Liang on 2018/11/28.
 */
public interface IUserService<T> {

    void save(T user);

    void update(T user);

    void delete(T user);

    int count(T user);

    List<T> findAll();

    T findById(Integer id);

    List<T> findByCriteria(T user);

    List<T> findByPage(int pageindex, int pagesize, T user);

}
