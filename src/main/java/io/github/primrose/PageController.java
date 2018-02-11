/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.primrose;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
}
