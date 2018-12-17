package com.hlc.styd.smes.frame.sb.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;

/**
 * Created by Liang on 2018/12/14.
 */
@Component
public class ThreadRunnable {

    @Autowired
    private Executor taskExecutor;

    public void executeThread(String result) {
        this.taskExecutor.execute(new Task(result));
    }

}
