package com.hlc.styd.smes.sb.dubbo.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by Liang on 2018/11/30.
 */
@SpringBootApplication
@ImportResource("classpath:dubbo-consumer.xml")
public class DubboConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApplication.class);
    }

}
