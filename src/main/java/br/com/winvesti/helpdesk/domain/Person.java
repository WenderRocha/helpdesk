package br.com.winvesti.helpdesk.domain;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.winvesti.helpdesk.domain.enums.Profile;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class Person {

	@EqualsAndHashCode.Include
	protected Long id;

	protected String name;

	@EqualsAndHashCode.Include
	protected String cpf;

	protected String password;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	protected Instant created_at = Instant.now();

	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	protected Set<Integer> profiles = new HashSet<>();

	public Person() {
		super();
		addProfile(Profile.CLIENT);
	}

	public Person(Long id, String name, String cpf, String password) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.password = password;
		addProfile(Profile.CLIENT);
	}

	public Set<Profile> getProfiles() {
		return profiles.stream().map(x -> Profile.toEnum(x)).collect(Collectors.toSet());
	}

	public void addProfile(Profile profile) {
		this.profiles.add(profile.getCode());
	}

}
