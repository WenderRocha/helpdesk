package br.com.winvesti.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.winvesti.helpdesk.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
