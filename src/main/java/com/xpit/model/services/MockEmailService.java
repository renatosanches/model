package com.xpit.model.services;

/* Back End - API REST 
 * Service - Camada de Servicos do Controlador Rest 
 * Classe Simulacao do envio de email - Responsavel pelos servicos de email (operacões oferecidas do servico de e-mail) 
 * Somente para Teste gerando log por  Logger - Email Fake Teste
 * Java + Spring Framework
 * Renato Sanches - XP IT Tecnologia 
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

public class MockEmailService extends AbstractEmailService {

	//  instancia o Logger LoggerFactory para imprimir um log de mensagem simulacao envio de email
	//	O método @Bean EmailService que retorna uma instância de MockEmailService (definido em TestConfig)
	private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);

	@Override
	public void sendEmail(SimpleMailMessage msg) {
		LOG.info("Simulando envio de email...");
		LOG.info(msg.toString());
		LOG.info("Email enviado");
	}
	

}
