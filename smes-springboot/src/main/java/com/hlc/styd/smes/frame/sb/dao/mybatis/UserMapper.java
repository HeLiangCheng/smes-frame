package com.hlc.styd.smes.frame.sb.dao.mybatis;

import com.hlc.styd.smes.frame.sb.entity.Db_User;

import java.util.HashMap;
import java.util.List;

/**
 * 简单方便。适用于比较简单的SQL
 */
public interface UserMapper {

    int deleteByKey(Integer id);

    int insert(Db_User record);

    Db_User selectByKey(Integer id);

    int update(Db_User record);

    int count(Db_User record);

    List<Db_User> selectAll();

    List<Db_User> selectByPage(HashMap<String,Object> param);

}