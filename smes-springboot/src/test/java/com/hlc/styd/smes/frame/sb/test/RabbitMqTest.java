package com.hlc.styd.smes.frame.sb.test;

import com.hlc.styd.smes.frame.sb.mq.Receiver;
import com.hlc.styd.smes.frame.sb.mq.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Liang on 2018/11/30.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqTest {

    @Autowired
    private Sender sender;
    @Autowired
    private Receiver receiver;

    @Test
    public void test1(){
        sender.send();
    }


}
