package com.hlc.styd.smes.frame.sb.controller;

import com.hlc.styd.smes.frame.sb.entity.Db_User;
import com.hlc.styd.smes.frame.sb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Liang on 2018/11/27.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService<Db_User> jdbcUserService;

    @Autowired
    private IUserService<Db_User> ehuserService;

    @RequestMapping("/list")
    @ResponseBody
    public List<Db_User> getlist() {
        List<Db_User> userList = jdbcUserService.findAll();
        return userList;
    }

    @RequestMapping("/list2")
    @ResponseBody
    public List<Db_User> getlist2() {
        List<Db_User> userList = ehuserService.findAll();
        return userList;
    }

    @RequestMapping("/{id}")
    @ResponseBody
    public Db_User getlist2(@PathVariable(name = "id") int id) {
        Db_User user = ehuserService.findById(id);
        return user;
    }

}
