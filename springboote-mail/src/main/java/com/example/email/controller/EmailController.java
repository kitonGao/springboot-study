package com.example.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @ClassName EmailController
 * @Description
 * @create 2019/8/21/0021 14:22
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
@RestController
@RequestMapping(value = "/email")
public class EmailController {

    @Autowired
    private JavaMailSender jms;

    @Value("${spring.mail.username}")
    private String from;

    @RequestMapping("/sendSimpleEmail")
    public String sendSimpleEmail(){
        try {

            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(from);
            message.setTo("888.com");
            message.setSubject("标题");
            message.setText("内容");
            jms.send(message);
            return "发送成功";
        }catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }

    }


    @RequestMapping("/sendMessage")
    public String sendHtmlEmail(){
        try {
            MimeMessage message = jms.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo("11.com");
            helper.setSubject("标题");
            /*带HTML格式的内容*/
//            StringBuffer stringBuffer = new StringBuffer("<p style='color:black'>使用SPring Boot发送HTML邮件。</p>");

            StringBuffer stringBuffer1 = new StringBuffer("<html><body>博客图：<img src='cid:img'/></body></html>");

//            helper.setText(stringBuffer.toString(), true);
            helper.setText(stringBuffer1.toString(), true);

            /*增加附件*/
            FileSystemResource file = new FileSystemResource(new File("src/main/resource/static/1.docx"));
            helper.addAttachment("项目文档.docx", file);

            /*带有静态资源的邮件（img和图片标签里的cid后的名称相对应）*/
            FileSystemResource file2 = new FileSystemResource(new File("src/main/resource/static/1.docx"));
            helper.addInline("img",file2);



            jms.send(message);
            return "发送成功";
        }catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }



}
