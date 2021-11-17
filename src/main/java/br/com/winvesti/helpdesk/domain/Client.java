package br.com.winvesti.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;


public class Client extends Person{
	
	private List<Request> requests = new ArrayList<>();

	public Client() {
		super();
	}

	public Client(Long id, String name, String cpf, String password) {
		super(id, name, cpf, password);
	}

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}
	
	
	
}
