package com.hlc.styd.smes.frame.sb.test;

import com.hlc.styd.smes.frame.sb.mail.EmailDto;
import com.hlc.styd.smes.frame.sb.mail.MailSenderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

/**
 * Created by Liang on 2018/11/30.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

    @Autowired
    private MailSenderService mailSenderService;
    @Value("${spring.mail.username}")
    private String from;

    @Test
    public void test() {
        //构造邮件对象
        EmailDto emailDto = new EmailDto();
        emailDto.setFrom(from);
        //收件人
        ArrayList<String> tolist = new ArrayList<String>();
        tolist.add("1032640718@qq.com");
        emailDto.setTo(tolist);
        emailDto.setSubject("主题：测试邮件发送，简单发送");
        emailDto.setContent("测试邮件简单发送的内容");
        mailSenderService.sendSimpleEmail(emailDto);
    }

}
