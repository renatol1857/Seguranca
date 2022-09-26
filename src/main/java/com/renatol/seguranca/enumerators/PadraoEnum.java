package com.renatol.seguranca.enumerators;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PadraoEnum {
	PARTE_INICIO(1, "Inicio do dado"), PARTE_MEIO(2, "Meio do dado"), PARTE_FINAL(3, "Final do dado"),
	TAMANHO(4, "Tamanha minimo"), FONE_CELULAR(5, "Somente celular"), FONE_FIXO(6, "Somente celular"),
	FONE_RAMAL(7, "Somente celular"),
	NO_STRING(8, "Nao permitir string"), ONLY_STRING(9, "Somente string");

	private int cod;
	private String descricao;
	

}
