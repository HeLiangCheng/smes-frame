package com.hlc.styd.smes.frame.sb.controller;

import com.hlc.styd.smes.frame.sb.exception.SmesException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Liang on 2018/11/27.
 */
@RestController
@RequestMapping("/test")
@Api(value = "测试Controller")
public class HelloController {

    @Value("${smes.en}")
    private String en;

    @ApiOperation(value="springboot的第一个方法")
    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }

    @ApiOperation(value="当前环境参数")
    @GetMapping("/en")
    public String getEn() {
        return en;
    }


    @ApiOperation(value="当前环境参数")
    @GetMapping("/division/{num}")
    public String division(@PathVariable(value = "num") int num) throws SmesException {
        int retlut = 0;
        try {
            retlut = 5 / num;
        } catch (Exception ex) {
            throw new SmesException(ex.getMessage());
        }
        return "运算结果： "+retlut;
    }

}
