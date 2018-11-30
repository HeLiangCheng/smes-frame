package com.hlc.styd.smes.frame.sb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Liang on 2018/11/30.
 */
@Controller
@RequestMapping
public class LoginController {

    @RequestMapping("/login")
    public String login(ModelMap map) {
        map.addAttribute("login", true);
        return "login";
    }

}
