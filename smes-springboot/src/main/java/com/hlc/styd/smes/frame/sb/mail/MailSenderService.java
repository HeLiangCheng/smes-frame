package com.hlc.styd.smes.frame.sb.mail;

import freemarker.template.Template;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Map;

/**
 * Created by Liang on 2018/11/30.
 */
@Component("mailSenderService")
public class MailSenderService {

    private Logger logger = LoggerFactory.getLogger(getClass());
    //注入邮件依赖
    @Autowired
    private JavaMailSender javaMailSender;
    //根据模板生成邮件内容
    @Autowired
    private FreeMarkerConfigurer configurer;

    //发送简单内容邮件
    public void sendSimpleEmail(EmailDto emailDto) {
        //发送一个简单的邮件
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailDto.getFrom());
        message.setTo(StringUtils.join(emailDto.getTo(), ","));
        message.setSubject(emailDto.getSubject());
        message.setText(emailDto.getContent());
        javaMailSender.send(message);
    }


    //发送带模板格式邮件
    public void sendMultiEmail(EmailDto emailDto,Map<String,Object> model,String template) {
        try {
            //发送模板邮件
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(emailDto.getFrom());
            helper.setTo(StringUtils.join(emailDto.getTo(), ","));
            helper.setSubject(emailDto.getSubject());
            //构造邮件内容
            Template frtemplat = configurer.getConfiguration().getTemplate(template);
            String emailBody = FreeMarkerTemplateUtils.processTemplateIntoString(frtemplat, model);
            helper.setText(emailBody, true);
            //添加附件
            for (EmailFileDto item : emailDto.getFilelist()) {
                if (FileType.Local.equals(item.getType())) {
                    FileSystemResource file = new FileSystemResource(new File(item.getFilepath()));
                    helper.addAttachment(item.getFilename(), file);
                }
            }
            //发送邮件
            javaMailSender.send(message);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }

}
