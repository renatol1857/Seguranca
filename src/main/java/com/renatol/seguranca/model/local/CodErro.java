package com.renatol.seguranca.model.local;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.renatol.seguranca.model.global.Usuario;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tbcod_erros")
public class CodErro implements Serializable{
	@Transient
	@Setter(AccessLevel.NONE)
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String cod;
	
	private String msg;
	
	private String statusHttp;

	public CodErro(String cod, String statusHttp, String msg) {
		super();
		this.cod = cod;
		this.statusHttp = statusHttp;
		this.msg = msg;
	}
	
	
	
	
}
