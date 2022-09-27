package com.renatol.seguranca.repositories.local;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renatol.seguranca.model.local.CodErro;

public interface CodErroRepository extends JpaRepository<CodErro, Long>{

	public CodErro findByCod(String codError);
}
