package com.xpit.model.config;

/* Back End - API REST
 * Java + Spring Framework
 * Renato Sanches - XP IT Tecnologia 
 */

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.xpit.model.services.DBService;
import com.xpit.model.services.EmailService;
import com.xpit.model.services.MockEmailService;

//Configuração do ambiente de teste com banco de dados h2 im memory que chama DBService e efetua a instanciacao/persistencia dos dados8082
@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBService dbService;

	@Bean
	public boolean instantiateDatabase() throws ParseException {
		dbService.instantiateTestDatabase();
		return true;
	}
	
	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}
	

}
