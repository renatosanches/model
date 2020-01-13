package com.xpit.model.services;

import javax.mail.internet.MimeMessage;

/* Back End - API REST 
 * Service - Camada de Servicos do Controlador Rest 
 * //Classe responsavel por Implementar o SmtpEmailService utilizando nele uma instância de MailSender 
 * Java + Spring Framework
 * Renato Sanches - XP IT Tecnologia 
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class SmtpEmailService extends AbstractEmailService {

	//Vai instanciar Mailsender com dados do application.properties do ambiente em questao (TST/DEV/PRD)
	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private JavaMailSender javaMailSender;

	// Monta Log e envia o e-mail
	private static final Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);

	@Override
	public void sendEmail(SimpleMailMessage msg) {
		LOG.info("Enviando email...");
		mailSender.send(msg);
		LOG.info("Email enviado");
	}

	@Override
	public void sendHtmlEmail(MimeMessage msg) {
		LOG.info("Enviando email...");
		javaMailSender.send(msg);
		LOG.info("Email enviado");
		
	}
}
