package com.hlc.styd.smes.frame.sb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by Liang on 2018/11/27.
 */
@SpringBootApplication
@EnableAutoConfiguration
@MapperScan("com.hlc.styd.smes.frame.sb.dao.mybatis")
@EnableScheduling
public class SmesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmesApplication.class, args);
    }

}
