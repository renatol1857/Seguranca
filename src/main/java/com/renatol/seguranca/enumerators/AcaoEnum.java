package com.renatol.seguranca.enumerators;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AcaoEnum {
	CREATE(1, "Create a new entity."),
	UPDATE(2, "Update an entity."),
	DELETE(3, "Delete an entity.");

	private int cod;
	private String descricao;
	
	public static AcaoEnum toEnum(Integer cod) {
		if (cod == null)
			throw new IllegalArgumentException(String.format("Cod fora do padrao tipo %s", AcaoEnum.class.getName()));
		for (AcaoEnum x : AcaoEnum.values()) {
			if (cod.equals(x.getCod()))
				return x;
		}	
		throw new IllegalArgumentException(String.format("Cod fora do padrao tipo %s", AcaoEnum.class.getName()));
	}
}
