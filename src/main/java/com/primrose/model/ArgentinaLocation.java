/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.primrose.model;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author usuario
 */
@Getter
@Setter
public class ArgentinaLocation implements Serializable{
    private String iso_31662;
    private String provincia;
    private String capital;
    private List<String> localidad;
}
