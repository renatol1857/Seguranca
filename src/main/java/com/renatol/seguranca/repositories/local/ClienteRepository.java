package com.renatol.seguranca.repositories.local;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renatol.seguranca.model.local.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
