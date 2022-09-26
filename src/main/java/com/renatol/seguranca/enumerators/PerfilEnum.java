package com.renatol.seguranca.enumerators;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PerfilEnum {
	USUARIO(1,"Usuário"),
	RELATORIO(2,"Relatórios"),
	SUPERVISOR(3,"Supoervisor"),
	ADMIN(4,"Administrador");

	private int cod;
	private String descricao;
	
	public static PerfilEnum toEnum(Integer cod) {
		if (cod == null)
			throw new IllegalArgumentException(String.format("Cod fora do padrao tipo %s", PerfilEnum.class.getName()));
		for (PerfilEnum x : PerfilEnum.values()) {
			if (cod.equals(x.getCod()))
				return x;
		}	
		throw new IllegalArgumentException(String.format("Cod fora do padrao tipo %s", PerfilEnum.class.getName()));
	}
	
	public static Boolean isCodValid(Integer cod) {
		for (PerfilEnum x : PerfilEnum.values()) {
			if (cod.equals(x.getCod()))
				return true;
		}	
		return false;
	}

}
