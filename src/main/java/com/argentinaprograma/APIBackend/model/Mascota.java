/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argentinaprograma.APIBackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author guille
 */

@Getter
@Setter
@Entity
public class Mascota {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
        
    @Column
    private String nombre;
    
    
    @Column
    private Integer edad;

        
}
