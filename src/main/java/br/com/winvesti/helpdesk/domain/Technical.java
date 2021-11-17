package br.com.winvesti.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;

public class Technical extends Person{
	
	private List<Request> requests = new ArrayList<>();

	public Technical() {
		super();
	}

	public Technical(Long id, String name, String cpf, String password) {
		super(id, name, cpf, password);
	}

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}
	
	
}
