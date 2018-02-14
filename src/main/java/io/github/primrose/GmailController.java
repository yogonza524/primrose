/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.primrose;

import com.primrose.gmail.GmailService;
import com.primrose.model.User;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import org.apache.commons.io.IOUtils;
import org.hazlewood.connor.bottema.emailaddress.EmailAddressValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author usuario
 */
@RestController
public class GmailController {
    
    @Autowired GmailService gmail;
    
    @RequestMapping(value = "/users/register", method =  RequestMethod.POST)
    public ResponseEntity register(@RequestBody User user) throws MessagingException {
        
        Map<String, Object> map = new HashMap<>();
        
        if (user.getEmail() == null) {
            map.put("status", 400);
            map.put("message", "Email es requerido. No se ha enviado el email");
            map.put("exception", "Email is mandatory");
            
            return new ResponseEntity(map, HttpStatus.NOT_ACCEPTABLE);
        }
        if (!EmailAddressValidator.isValid(user.getEmail())) {
            map.put("status", 400);
            map.put("message", "Email con formato invalido");
            map.put("exception", "email has not the correct format. Expected: email RFC2822");
            
            return new ResponseEntity(map, HttpStatus.NOT_ACCEPTABLE);
        }
        if (user.getName() == null) {
            map.put("status", 400);
            map.put("message", "Nombre requerido, no se ha enviado el email");
            map.put("exception", "Name is a mandatory field");
            
            return new ResponseEntity(map, HttpStatus.NOT_ACCEPTABLE);
        }
        
        try {
            String template = IOUtils
                    .toString(
                        GmailController.class.getResourceAsStream("/static/email/registerOk.html"),
                        "UTF-8")
                    .replaceAll("NOMBRE_DE_USUARIO", user.getName());
            
            new Thread(() -> {
                try { 
                    gmail.send(user.getEmail(), "REGISTRACION EXITOSA", template);
                } catch (MessagingException ex) {
                    Logger.getLogger(GmailController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }).start();
            
//            gmail.send(user.getEmail(), "REGISTRACION EXITOSA", template);
        } catch (IOException ex) {
            Logger.getLogger(GmailController.class.getName()).log(Level.SEVERE, null, ex);
            
            map.put("status", 500);
            map.put("message", ex.getMessage());
            map.put("exception", Arrays.toString(ex.getStackTrace()));
            
            return new ResponseEntity(map, HttpStatus.CONFLICT);
        }
        
        map.put("status", 200);
        map.put("message", "Hemos enviado un mail a tu casilla " + user.getEmail());
        map.put("exception", "");
            
        return new ResponseEntity(map, HttpStatus.OK);
    }
}
