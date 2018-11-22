package com.hlc.styd.smes.web.dao;

import com.hlc.styd.smes.web.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Liang on 2018/11/21.
 */
public interface IUserDao {

    int save(User user);

    int update(User user);

    int delete(int id);

    User selectByKey(int id);

    List<User> selectList(User user);

    int count(User user);

}
