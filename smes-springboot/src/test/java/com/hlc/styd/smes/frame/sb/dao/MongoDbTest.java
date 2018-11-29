package com.hlc.styd.smes.frame.sb.dao;

import com.hlc.styd.smes.frame.sb.entity.Db_User;
import com.hlc.styd.smes.frame.sb.mongodb.UserMongoRepository;
import org.apache.catalina.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by Liang on 2018/11/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoDbTest {

    @Autowired
    private UserMongoRepository userMongoRepository;

    @Test
    public void test1() {
        Db_User user = new Db_User();
        user.setId(123);
        user.setName("redis");
        user.setUsername("redis");
        user.setPassword("123456");
        user.setBirthday(new Date());
        user.setGander("男");
        userMongoRepository.save(user);
    }


    @Test
    public void test2() {
        List<Db_User> userlist = userMongoRepository.findAll();
        userlist.forEach(t->{
            System.out.println(t.toString());
        });
    }


}
