package br.com.winvesti.helpdesk.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.winvesti.helpdesk.domain.enums.Role;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "tb_person")
public abstract class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	protected String name;

	@EqualsAndHashCode.Include
	@Column(unique = true)
	protected String cpf;
	
	@Column(unique = true)
	protected String email;

	protected String password;

	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate created_at = LocalDate.now();

	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "ROLES")
	protected Set<Integer> roles = new HashSet<>();

	public Person() {
		super();
		addRole(Role.CLIENT);
	}

	public Person(Long id, String name, String cpf, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.password = password;
		addRole(Role.CLIENT);
	}

	public Set<Role> getProfiles() {
		return roles.stream().map(x -> Role.toEnum(x)).collect(Collectors.toSet());
	}

	public void addRole(Role profile) {
		this.roles.add(profile.getCode());
	}

}
