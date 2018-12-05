package com.hlc.styd.smes.sb.dubbo.consumer.controller;

import com.hlc.styd.smes.sb.dubbo.api.IUserService;
import com.hlc.styd.smes.sb.dubbo.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Liang on 2018/12/5.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;


    @GetMapping("/")
    public List<UserDto> getUserList(){
        return userService.findAll();
    }

}
