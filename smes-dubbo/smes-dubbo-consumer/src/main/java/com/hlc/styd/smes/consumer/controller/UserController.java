package com.hlc.styd.smes.consumer.controller;


import com.hlc.styd.smes.api.dto.UserDto;
import com.hlc.styd.smes.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Liang on 2018/11/22.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getUser(String name) {
        UserDto user = new UserDto();
        user.setName(name);
        List<UserDto> users = userService.findByUser(user);
        Map<String, Object> reltmap = new HashMap<String, Object>();
        reltmap.put("userlist", users);
        return new ModelAndView("userlist", reltmap);
    }


    @RequestMapping(value = "/rest", method = RequestMethod.GET)
    @ResponseBody
    public  List<UserDto> getUserByRest(String name) {
        UserDto user = new UserDto();
        user.setName(name);
        List<UserDto> users = userService.findByUser(user);
        return users;
    }

}
