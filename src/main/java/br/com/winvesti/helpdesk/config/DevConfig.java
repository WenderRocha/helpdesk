package br.com.winvesti.helpdesk.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.winvesti.helpdesk.domain.Client;
import br.com.winvesti.helpdesk.domain.Request;
import br.com.winvesti.helpdesk.domain.Technical;
import br.com.winvesti.helpdesk.domain.enums.Priority;
import br.com.winvesti.helpdesk.domain.enums.Role;
import org.springframework.context.annotation.Profile;
import br.com.winvesti.helpdesk.domain.enums.Status;
import br.com.winvesti.helpdesk.repositories.ClientRepository;
import br.com.winvesti.helpdesk.repositories.RequestRepository;
import br.com.winvesti.helpdesk.repositories.TechnicalRepository;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Configuration
@Profile(value = "dev")
public class DevConfig implements CommandLineRunner{
	
	private final TechnicalRepository technicalRepository;
	private final ClientRepository clientRepository;
	private final RequestRepository requestRepository;

	@Override
	public void run(String... args) throws Exception {
		Technical t1 = new Technical(null, "Lucca Iago Ribeiro", "248.066.759-62","lucca@mail.com", "12345678");
		t1.addRole(Role.ADMIN);
		
		Client c1 = new Client(null, "Simone Ayla Barros", "009.375.961-40", "aylabarros@mail.com", "123456");
		
		Request r1 = new Request(null, "Chamadao 01", "primeiro chamado", Priority.MEDIUM, Status.PROGRESS,c1, t1 );
		
		technicalRepository.saveAll(Arrays.asList(t1));
		clientRepository.saveAll(Arrays.asList(c1));
		requestRepository.saveAll(Arrays.asList(r1));
		
	}

}
