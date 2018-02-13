/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.primrose.gmail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 *
 * @author usuario
 */
@Service
public class GmailService {
    
    @Autowired
    public JavaMailSender mailSender;
    
    public void sendSimpleMessage(
      String to, String subject, String text) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
        mimeMessage.setContent(text, "text/html");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setFrom("publicame2018@gmail.com");
        mailSender.send(mimeMessage);
    }
}
