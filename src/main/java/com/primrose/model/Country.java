/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.primrose.model;

import java.io.Serializable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


/**
 *
 * @author usuario
 */
@Getter
@Setter
@Builder
public class Country implements Serializable{
    private String name;
    private String code;
}
