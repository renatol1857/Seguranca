package com.renatol.seguranca.repositories.global;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renatol.seguranca.model.global.Usuario;

public interface UsuarioRepositpry extends JpaRepository<Usuario, Long> {

}
