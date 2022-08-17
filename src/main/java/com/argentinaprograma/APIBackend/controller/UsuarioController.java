package com.argentinaprograma.APIBackend.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.argentinaprograma.APIBackend.model.Usuario;

public interface UsuarioController extends JpaRepository<Usuario, Long> {

}
