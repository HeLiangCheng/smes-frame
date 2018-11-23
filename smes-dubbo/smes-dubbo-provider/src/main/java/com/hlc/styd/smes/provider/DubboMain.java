package com.hlc.styd.smes.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

/**
 * Created by Liang on 2018/11/22.
 * Dubbo启动类
 */
public class DubboMain {

    private static Logger logger = LoggerFactory.getLogger("DubboMain");

    public static void main(String[] args) {
        //com.alibaba.dubbo.container.Main.main(args);
        try {
            //启动加载配置，建立DUBBO连接
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:application*.xml"});
            context.start();
            logger.info("dubbo服务启动成功");
            //控制程序退出
            Scanner scanner = new Scanner(System.in);
            while (true) {
                if (scanner.hasNext()) {
                    String x = scanner.nextLine();
                    if ("exit".equals(x))
                        break;
                    logger.info("输入exit停止程序！");
                }
            }
            context.close();
            scanner.close();
        } catch (Exception e) {
            logger.error("dubbo服务启动失败，原因：" + e.getMessage());
        }
    }
}
