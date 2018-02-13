/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.primrose;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.primrose.model.ArgentinaLocation;
import com.primrose.model.Country;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 *
 * @author Gonzalo H. Mendoza
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    List<Country> paises() {
        Type REVIEW_TYPE = new TypeToken<List<Country>>() {
        }.getType();
        Gson gson = new Gson();
        
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("json/countries.json").getFile());
        
        JsonReader reader = null;
        try {
            reader = new JsonReader(new FileReader(file));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reader != null? gson.fromJson(reader, REVIEW_TYPE) : null;
    }
    
    @Bean
    List<ArgentinaLocation> localidadesArgentina() {
        Type REVIEW_TYPE = new TypeToken<List<ArgentinaLocation>>() {
        }.getType();
        Gson gson = new Gson();
        
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("json/argentina.json").getFile());
        
        JsonReader reader = null;
        try {
            reader = new JsonReader(new FileReader(file));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reader != null? gson.fromJson(reader, REVIEW_TYPE) : null;
    }
    
    @Bean
    JavaMailSender mailSender() {
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
}
