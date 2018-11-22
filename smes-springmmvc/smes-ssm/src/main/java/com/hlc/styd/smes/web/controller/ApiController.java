package com.hlc.styd.smes.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.hlc.styd.smes.web.entity.User;
import com.hlc.styd.smes.web.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Created by Liang on 2018/11/22.
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private UserService userService;
    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    @ResponseBody  //将返回结果进行json编码
    public List<User> getUser(String name) {
        log.info("请求User json数据");
        User user = new User();
        user.setName(name);
        List<User> users = userService.findByUser(user);
        log.info(JSONObject.toJSONString(users));
        return users;
    }

}

