package com.hlc.styd.smes.frame.sb.test;

import com.hlc.styd.smes.frame.sb.dao.mybatis.User2Mapper;
import com.hlc.styd.smes.frame.sb.entity.Db_User;
import com.hlc.styd.smes.frame.sb.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by Liang on 2018/11/28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisUserServiceTest {

    @Autowired
    private IUserService mybatisUserService;

    @Autowired
    private User2Mapper user2Mapper;

    @Test
    public void test(){
       List<Db_User> userList = mybatisUserService.findAll();
       userList.forEach(t->{
           System.out.println(t.toString());
       });
    }

    @Test
    public void test2(){
        int num = mybatisUserService.count(null);
        System.out.println(num);
    }

    @Test
    public void test3(){
        List<Db_User> userList = user2Mapper.selectAll();
        userList.forEach(t->{
            System.out.println(t.toString());
        });
    }

}
