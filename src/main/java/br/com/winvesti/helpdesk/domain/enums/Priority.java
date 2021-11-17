package br.com.winvesti.helpdesk.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Priority {
	
	LOW(1, "LOW"),
	MEDIUM(2, "MEDIUM"),
	HIGH(3, "HIGH");
	
	private Integer code;
	private String msg;
	
	public static Priority toEnum(Integer code) {
		if(code == null) {
			return null;
		}
		
		for(Priority p : Priority.values()) {
			if(p.equals(code)) {
				return p;
			}
		}
		
		throw new IllegalArgumentException("Priority Inválid!");
	}
}
