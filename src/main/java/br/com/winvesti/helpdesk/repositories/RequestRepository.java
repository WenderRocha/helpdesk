package br.com.winvesti.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.winvesti.helpdesk.domain.Request;

public interface RequestRepository extends JpaRepository<Request, Long>{

}
