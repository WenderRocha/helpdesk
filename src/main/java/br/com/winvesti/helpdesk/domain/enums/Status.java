package br.com.winvesti.helpdesk.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Status {

	OPEN(1, "OPEN"),
	PROGRESS(2, "PROGRESS"),
	CLOSED(3, "CLOSED");
	
	private Integer code;
	private String msg;
	
	public static Status toEnum(Integer code) {
		if(code == null) {
			return null;
		}
		
		for(Status s : Status.values()){
			if(s.equals(code)) {
				return s;
			}
		}
		
		throw new IllegalArgumentException("Status inválid!");
	}
}
