package com.hlc.styd.smes.frame.sb.thread;

import org.apache.tomcat.jni.Thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by Liang on 2018/12/14.
 */
public class Task implements Runnable {

    private SimpleDateFormat dateFormat = new SimpleDateFormat();
    private String threadname;

    public Task() {
    }

    public Task(String name) {
        this.threadname = name;
    }

    @Override
    public void run() {
        try {
            java.lang.Thread.sleep(new Random().nextInt(100));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("线程：" + java.lang.Thread.currentThread().getName() +" 线程编号："+threadname+" 开始运行时间" + dateFormat.format(new Date()));
    }

}
