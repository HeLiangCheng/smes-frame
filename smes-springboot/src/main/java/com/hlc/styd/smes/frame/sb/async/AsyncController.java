package com.hlc.styd.smes.frame.sb.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * Created by Liang on 2018/11/29.
 */
@RestController
@RequestMapping("/async")
public class AsyncController {

    @Autowired
    private AsyncTask asyncTask;

    //使用Callable创建多线程实现异步
    @RequestMapping("/callable")
    public void asyn() {
        System.out.println("使用Callable创建多线程异步执行");
        Callable<String> callone = new Callable<String>() {
            @Override
            public String call() throws Exception {
                int i = 0;
                while (i < 10) {
                    i++;
                    System.out.println("asyn-callable");
                }
                return "call-1";
            }
        };
        try {
            callone.call();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    //使用Async注解实现异步调用不带返回值
    @RequestMapping("/noback")
    public void asyncMarkNoBack() {
        System.out.println("使用async注解创建多线程异步执行不带返回值服务");
        asyncTask.task1();
        asyncTask.task2();
        asyncTask.task3();
    }


    //使用Async注解实现异步调用，带返回值
    @RequestMapping("/withback")
    public void asyncMarkWithBack() {
        System.out.println("使用async注解创建多线程异步执行不带返回值服务");
        Future<String> relut1 = asyncTask.task4();
        Future<String> relut2 = asyncTask.task5();
        try {
            System.out.println(relut1.get().toString());
            System.out.println(relut2.get().toString());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


}
