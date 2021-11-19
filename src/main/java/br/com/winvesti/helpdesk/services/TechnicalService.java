package br.com.winvesti.helpdesk.services;

import java.util.List;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.winvesti.helpdesk.domain.Technical;
import br.com.winvesti.helpdesk.repositories.TechnicalRepository;
import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor
public class TechnicalService {

	private final TechnicalRepository repository;
	
	public List<Technical> findAll(){
		return repository.findAll();
	}
	
	public Technical findById(Long id) {
		Optional<Technical> obj = repository.findById(id);
		return obj.orElse(null);
	}
	
	
}
