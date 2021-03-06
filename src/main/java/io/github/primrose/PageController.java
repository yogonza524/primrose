/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.primrose;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Gonzalo H. Mendoza
 */
@Controller
public class PageController {
    
    @RequestMapping("/home")
    public String greeting(Model model) {
        
        return "home";
    }
    
    @RequestMapping("/register")
    public String register(Model model) {
        return "register";
    }
    
    @RequestMapping("/access")
    public String access(Model model) {
        return "access";
    }
    
    @RequestMapping("/recover_pass")
    public String recoverPass(Model model) {
        return "recover_pass";
    }
    
    @RequestMapping("/recover_email")
    public String recoverEmail(Model model) {
        return "recover_email";
    }
    
    @RequestMapping("/publish")
    public String publish(Model model) {
        return "publish";
    }
    
    @RequestMapping("/publication/{id}")
    public String publication(@PathVariable("id") String id, Model model) {
        return "register";
    }
}
