package com.hlc.styd.smes.consumer.controller;

import com.hlc.styd.smes.api.mongo.MongoCompanyDto;
import com.hlc.styd.smes.api.service.MongoCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Liang on 2018/11/26.
 */
@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private MongoCompanyService mongoCompanyService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getUser(String name) {
        MongoCompanyDto companyDto = new MongoCompanyDto();
        companyDto.setCompanyName(name);
        List<MongoCompanyDto> companyList = mongoCompanyService.findAll();
        Map<String, Object> reltmap = new HashMap<String, Object>();
        reltmap.put("companyList", companyList);
        return new ModelAndView("companylist", reltmap);
    }

}
