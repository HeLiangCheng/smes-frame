package com.hlc.styd.smes.web.controller;

import com.hlc.styd.smes.web.entity.User;
import com.hlc.styd.smes.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView getUser(String name) {
        User user = new User();
        user.setName(name);
        List<User> users = userService.findByUser(user);
        Map<String, Object> reltmap = new HashMap<String, Object>();
        reltmap.put("userlist", users);
        return new ModelAndView("userlist", reltmap);
    }

}
