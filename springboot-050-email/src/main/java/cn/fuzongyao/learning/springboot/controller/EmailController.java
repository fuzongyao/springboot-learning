package cn.fuzongyao.learning.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p></p>
 *
 * @author fuzongyao
 * @date 2020-03-20
 * @since 1.0.0
 */
@RestController
public class EmailController {
    @Autowired
    private JavaMailSender mailSender;

    @PostMapping("/email/send")
    public void sendMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("fuzongyao.java@qq.com");
        message.setSubject("Java测试发送邮件");
        message.setText("成功");
        message.setFrom("fuzongyao.java@qq.com");

        mailSender.send(message);
    }
}
