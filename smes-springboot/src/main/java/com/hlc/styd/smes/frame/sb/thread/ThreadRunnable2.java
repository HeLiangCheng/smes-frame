package com.hlc.styd.smes.frame.sb.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/**
 * Created by Liang on 2018/12/14.
 * 多个线程执行完毕之后主线程开始执行
 */
@Component
public class ThreadRunnable2 {

    @Autowired
    private Executor taskExecutor;

    public void executeThread(String result,CountDownLatch latch) {
        this.taskExecutor.execute(new SimpleTask(result,latch));
    }

    private class SimpleTask implements Runnable {

        private String taskname;
        private CountDownLatch latch;
        private DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        public SimpleTask(String taskname, CountDownLatch latch) {
            this.taskname = taskname;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(new Random().nextInt(200));
                System.out.println("线程：" + Thread.currentThread().getName() + " 任务名称：" + taskname + " 执行时间：" + df.format(new Date()));

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }finally {
                if(latch!=null){
                    latch.countDown();
                }
            }
        }

    }


}
