package com.xpit.model.config;

/* Back End - API REST
 * Java + Spring Framework
 * Renato Sanches - XP IT Tecnologia 
 */

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.xpit.model.services.DBService;

//Configuração do ambiente de Desenvolvimento com banco de dados Mysql que chama DBService e efetua a instanciacao/persistencia dos dados 8082
@Configuration
@Profile("dev")
public class DevConfig {
	
	@Autowired
	private DBService dbService;

	//le configuraçoes do application-dev.propoerties chave spring.jpa.hibernate.ddl-auto e armazena na variavel strategy
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;

	@Bean
	public boolean instantiateDatabase() throws ParseException {

		// Se a Variavel strategy nao for igual a create nao faz nada
		if (!"create".equals(strategy)) {
			return false;
		}
		// Caso contrario cria a base de dados

		dbService.instantiateTestDatabase();
		return true;
	}
	

}
