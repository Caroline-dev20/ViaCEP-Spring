package com.example.viaCEP;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ViaCepApplication {
	
	private static final Logger log = LoggerFactory.getLogger(ViaCepApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ViaCepApplication.class);
	}
	
	@Bean
	public CommandLineRunner teste(CEPRepository repository) {
		return (args) -> {
			//save CEPs
			repository.save(new CEP("01001-000", "Praça da Sé", "lado ímpar", "Sé", "São Paulo", "SP"));
			
			//fetch all
			log.info("CEPs findAll():");
			for (CEP cep: repository.findAll()) {
				log.info(cep.toString());
			}
			log.info("");
			
			//fetch by cep
			CEP cep = repository.findByCep("01001-000");
			log.info("CEP findByCep('01001-000')");
			log.info(cep.toString());
			log.info("");
			
		};
	}

}
