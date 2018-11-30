package com.hlc.styd.smes.frame.sb.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Liang on 2018/11/29.
 *
 * springboot 定时任务
 *
 *  1.在springboot主类中启用EnableScheduling
 *  2.创建定时任务服务,并添加定时任务注解
         @Scheduled(fixedRate = 5000) ：上一次开始执行时间点之后5秒再执行
         @Scheduled(fixedDelay = 5000) ：上一次执行完毕时间点之后5秒再执行
         @Scheduled(initialDelay=1000, fixedRate=5000) ：第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
         @Scheduled(cron="5 * * * * *") ：通过cron表达式定义规则

        https://spring.io/guides/gs/scheduling-tasks/
 */
@Component
public class TaskService {

    @Scheduled(fixedDelay = 80000)
    public void task1(){
        System.out.println("定时任务task1执行.....");
    }

    @Scheduled(fixedDelay = 50000, initialDelay = 1000)
    public void task2(){
        System.out.println("定时任务task2执行.....");
    }


    @Scheduled(cron = "*/20 * * * * *")
    public void task3(){
        System.out.println("定时任务task3执行.....");
    }

}
