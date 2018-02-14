/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.primrose.model;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author usuario
 */
@Getter
@Setter
public class User {
    
    private String name;
    private String lastName;
    private String email;
    private String address;
    private String street;
    private String streetNumber;
    private String province;
    private String city;
    private String cel;
}
