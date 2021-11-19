package br.com.winvesti.helpdesk.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.winvesti.helpdesk.domain.Technical;
import br.com.winvesti.helpdesk.services.TechnicalService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "technicals")
@RequiredArgsConstructor
public class TechnicalResource {
	
	private final TechnicalService service;
	
	@GetMapping
	public ResponseEntity<List<Technical>> findAll(){
		List<Technical> technicals = service.findAll();	
		return ResponseEntity.ok().body(technicals);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Technical> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(service.findById(id));
	}

}
