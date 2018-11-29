package com.hlc.styd.smes.frame.sb.dao.mybatis;

import com.hlc.styd.smes.frame.sb.entity.Db_User;
import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;


@Mapper
public interface User2Mapper {

    @Delete("delete from user where id = #{id}")
    int deleteByKey(Integer id);

    @Insert("insert into user(name,username,password,gander,birthday) values (#{name},#{username},#{password},#{gander},#{birthday})")
    int insert(Db_User record);

    @Select("select * from user where id =#{id}")
    Db_User selectByKey(Integer id);

    @Update("update user set  where id =#{id}")
    int update(Db_User record);

    @Select("select count(*) from where name=#{name} and username=#{username}")
    int count(Db_User record);

    @Select("select * from user")
    List<Db_User> selectAll();

    @Select("select * from user where name=#{name} and username=#{username} limit #{pageindex},#{pagesize}")
    List<Db_User> selectByPage(HashMap<String, Object> param);

}