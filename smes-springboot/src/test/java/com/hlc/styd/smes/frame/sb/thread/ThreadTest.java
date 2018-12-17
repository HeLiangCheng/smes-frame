package com.hlc.styd.smes.frame.sb.thread;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Liang on 2018/12/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadTest {

    @Autowired
    private ThreadRunnable threadRunnable;
    @Autowired
    private ThreadRunnable2 threadRunnable2;

    @Test
    public void test() {
        for (int i = 0; i < 10; i++) {
            threadRunnable.executeThread("thread_" + i);
        }
        Scanner scanner = new Scanner(System.in);
        scanner.next();
    }


    @Test
    public void test2() {
        System.out.println("----------------线程开始执行------------------");
        CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            threadRunnable2.executeThread("task-" + i, latch);
        }
        try {
            latch.await();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println("主线程执行完毕！");
    }

}
