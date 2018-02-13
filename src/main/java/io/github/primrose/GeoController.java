/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.primrose;

import com.primrose.model.ArgentinaLocation;
import com.primrose.model.Country;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author usuario
 */
@RestController
public class GeoController {
    
    @Autowired private List<Country> paises;
    @Autowired private List<ArgentinaLocation> localidadesArgentina;
    
    @RequestMapping("/countries")
    public List<Country> paises() {
        return paises;
    }
    
    @RequestMapping("/argentina")
    public List<ArgentinaLocation> localidades() {
        return localidadesArgentina;
    }
}
