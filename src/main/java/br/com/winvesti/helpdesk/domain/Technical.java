package br.com.winvesti.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import br.com.winvesti.helpdesk.domain.enums.Profile;

@Entity
public class Technical extends Person{

	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "technical")
	private List<Request> requests = new ArrayList<>();

	public Technical() {
		super();
		addProfile(Profile.TECHNICAL);
	}

	public Technical(Long id, String name, String cpf, String email, String password) {
		super(id, name, cpf, email, password);
		addProfile(Profile.TECHNICAL);
	}

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}
	
	
}
