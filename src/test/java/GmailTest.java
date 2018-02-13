/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.apache.commons.io.IOUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 *
 * @author usuario
 */
public class GmailTest {
    
    public GmailTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void sendMailTest() throws FileNotFoundException, IOException {
        String template = IOUtils.toString(GmailTest.class.getResourceAsStream("/static/email/s.html"), "UTF-8");
        try {
            sendSimpleMessage("yogonza524@gmail.com", "PROBANDO", template);
        } catch (MessagingException ex) {
            Logger.getLogger(GmailTest.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public JavaMailSender mailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("publicame2018@gmail.com");
        mailSender.setPassword("jajkaN18.");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
     
     public void sendSimpleMessage(
      String to, String subject, String text) throws MessagingException {
        JavaMailSender mailSender = mailSender(); 
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
        mimeMessage.setContent(text, "text/html");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setFrom("publicame2018@gmail.com");
        mailSender.send(mimeMessage);
    }
     
     
}
