package com.hlc.styd.smes.frame.sb.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * Created by Liang on 2018/11/29.
 */
@Component
public class AsyncTask {

    private Logger logger = LoggerFactory.getLogger(getClass());

    //***********不带返回值的任务***********
    @Async
    public void task1() {
        try {
            Thread.sleep(1000);
            System.out.println("task1任务-执行");
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }

    @Async
    public void task2() {
        try {
            Thread.sleep(100);
            System.out.println("task2任务-执行");
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }

    @Async
    public void task3() {
        try {
            Thread.sleep(600);
            System.out.println("task3任务-执行");
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }


    //***********带返回值任务***********

    public Future<String> task4() {
        try {
            Thread.sleep(1000);
            System.out.println("task4任务-执行");
            Future<String> future = new AsyncResult<String>("执行结果1");
            return future;
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return null;
    }

    public Future<String> task5() {
        try {
            Thread.sleep(600);
            System.out.println("task5任务-执行");
            Future<String> future = new AsyncResult<String>("执行结果2");
            return future;
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return null;
    }

}
