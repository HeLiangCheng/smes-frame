package com.hlc.styd.smes.frame.sb.test;

import com.hlc.styd.smes.frame.sb.dao.jpa.JpaUserDao;
import com.hlc.styd.smes.frame.sb.entity.JPA_User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by Liang on 2018/11/27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaUserTest {

    @Autowired
    private JpaUserDao userDao;

    @Test
    public void userlist(){
        List<JPA_User> userList = userDao.findAll();
        userList.forEach(t->{
            System.out.println(t.toString());
        });
    }

    @Test
    public void useradd() {
        JPA_User user = new JPA_User();
        user.setName("test1");
        user.setUsername("test1");
        user.setGander("男");
        user.setPassword("123456");
        user.setBirthday(new Date());
        userDao.save(user);
    }

    @Test
    public void userbypage() {
        int page = 0;
        int size = 10;
        Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "id");
        Page<JPA_User> userList = userDao.findAll(pageable);
        userList.forEach(t -> {
            System.out.println(t.toString());
        });
    }



}

