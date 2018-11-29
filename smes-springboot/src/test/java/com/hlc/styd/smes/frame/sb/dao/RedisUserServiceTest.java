package com.hlc.styd.smes.frame.sb.dao;

import com.hlc.styd.smes.frame.sb.entity.Db_User;
import com.hlc.styd.smes.frame.sb.redis.RedisUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Created by Liang on 2018/11/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisUserServiceTest {

    @Autowired
    private RedisUserService redisUserService;

    @Test
    public void  test(){
        Db_User user = new Db_User();
        user.setId(123);
        user.setName("redis");
        user.setUsername("redis");
        user.setPassword("123456");
        user.setBirthday(new Date());
        user.setGander("男");
        redisUserService.save(user);
    }


    @Test
    public void  test2(){
        Db_User user = redisUserService.get("redis_db_user");
        System.out.println(user.toString());
    }

}

