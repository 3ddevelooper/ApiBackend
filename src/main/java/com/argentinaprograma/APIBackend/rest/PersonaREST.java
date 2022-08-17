/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argentinaprograma.APIBackend.rest;

import com.argentinaprograma.APIBackend.controller.PersonaController;
import com.argentinaprograma.APIBackend.model.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author guille
 */
@RestController
@RequestMapping("/persona")
public class PersonaREST {
    
    @Autowired
    private PersonaController personaController;
    
    @GetMapping("/listaCompleta")
    public List<Persona> everybody(){
        return personaController.findAll();
    }
    
    @PostMapping("/crear")
	public void guardar(@RequestBody Persona persona) {
		personaController.save(persona);
	}
}
