package com.renatol.seguranca.enumerators;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusEnum {
	DESATIVADO(1,"Desativado"),
	ATIVADO(2,"Ativado"),
	PAUSA(3,"Pausa"),
	MANUTENCAO(4,"Manutencao"),
	DEMO(5,"Demonstracao"),
	APAGADO(6,"Apagado");
	
	private int cod;
	private String descricao;
	
	public static StatusEnum toEnum(Integer cod) {
		if (cod == null)
			throw new IllegalArgumentException(String.format("Cod fora do padrao tipo %s", StatusEnum.class.getName()));
		for (StatusEnum x : StatusEnum.values()) {
			if (cod.equals(x.getCod()))
				return x;
		}	
		throw new IllegalArgumentException(String.format("Cod fora do padrao tipo %s", StatusEnum.class.getName()));
	}
		
	public static Boolean isCodValid(Integer cod) {
		for (StatusEnum x : StatusEnum.values()) {
			if (cod.equals(x.getCod()))
				return true;
		}	
		return false;
	}
}
