package com.renatol.seguranca.exception;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.renatol.seguranca.model.local.CodErro;
import com.renatol.seguranca.repositories.local.CodErroRepository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StandartError implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	CodErroRepository codErroRepository;
	
	private Integer httpCode;
	private String codMsg;
	private String msgGeral;
	private String msg;
	private String dh;
	
	public StandartError(Integer httpCode, String msg) {
		this.httpCode = httpCode;
		if (msg.length() <= 0)
			msg = "Error nao esperado";
		this.msg = msg;
		this.dh =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	public StandartError(String codMsg, Integer httpCode, String msg) {
		super();
		this.codMsg = "600";
		this.msgGeral = "Erro genêrico";
		/*
		//this.httpCode = httpCode;
		if (codMsg.length() > 0) {
			CodErro codErro = codErroRepository.findByCodErro(codMsg);
			if (codErro != null) {
				this.msgGeral = codErro.getMsg();
				this.codMsg = codMsg;
				//this.httpCode = Integer.valueOf(codErro.getStatusHttp());
			}
		}
		*/
		this.msg = msg;
		this.dh =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
	
	

}
