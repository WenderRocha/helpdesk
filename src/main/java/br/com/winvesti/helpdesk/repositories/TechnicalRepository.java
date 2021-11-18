package br.com.winvesti.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.winvesti.helpdesk.domain.Client;
import br.com.winvesti.helpdesk.domain.Technical;

public interface TechnicalRepository extends JpaRepository<Technical, Long>{

}
