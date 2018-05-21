package com.sgg.rest.controller;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;  
  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.mail.javamail.JavaMailSender;  
import org.springframework.mail.javamail.MimeMessageHelper;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RestController;  
  

  
@RestController  
@RequestMapping("mail")  
public class MailController {  
    @Autowired  
    JavaMailSender mailSender;  
      
    @RequestMapping("sendemail")  
    public String sendEmail() throws MessagingException  
    {  
            final MimeMessage mimeMessage = this.mailSender.createMimeMessage();  
            final MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
            message.setFrom("18852950196@163.com");
//            message.setFrom("1532697195@qq.com");
            message.setTo("455382077@qq.com");  
            message.setSubject("测试邮件主题");  
            message.setText("测试邮件内容");  
            this.mailSender.send(mimeMessage);  
            return "已发送";  
    }  
}  