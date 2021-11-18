package br.com.winvesti.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.winvesti.helpdesk.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
