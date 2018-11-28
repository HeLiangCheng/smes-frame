package com.hlc.styd.smes.frame.sb.dao;

import com.hlc.styd.smes.frame.sb.dao.jdbc.IUserDao;
import com.hlc.styd.smes.frame.sb.entity.Db_User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by Liang on 2018/11/27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JDBCUserTest {

    @Autowired
    private IUserDao userDao;

    @Test
    public void userlist(){
        List<Db_User> userList = userDao.findAll();
        userList.forEach(t->{
            System.out.println(t.toString());
        });
    }

    @Test
    public void useradd() {
        Db_User user = new Db_User();
        user.setName("test1");
        user.setUsername("test1");
        user.setGander("男");
        user.setPassword("123456");
        user.setBirthday(new Date());
        userDao.save(user);
    }


    @Test
    public void userListByPage(){
        List<Db_User> userList = userDao.findByPage(1,5,null);
        userList.forEach(t->{
            System.out.println(t.toString());
        });
    }

}
