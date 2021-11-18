package br.com.winvesti.helpdesk.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
	
	ADMIN(1, "ADMIN"),
	CLIENT(2, "CLIENT"),
	TECHNICAL(3, "TECHNICAL");
	
	private Integer code;
	private String msg;
	
	
	public static Role toEnum(Integer code) {
		if(code == null) {
			return null;
		}
		
		for (Role p : Role.values()) {
			if(code.equals(p.getCode())) {
				return p;
			}
		}
	
		throw new IllegalArgumentException("Profile inválid!");
		
	}
}
