package com.xpit.model.services;

/* Back End - API REST 
 * Service - Camada de Servicos do Controlador Rest 
 * Classe abstrata (padrão Template Method) - Responsavel pelos servicos de email (operacões oferecidas do servico de e-mail) * 
 * Java + Spring Framework
 * Renato Sanches - XP IT Tecnologia 
 */

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import com.xpit.model.domain.Pedido;

public abstract class AbstractEmailService implements EmailService {

	// Framework busca o valor do sender do arquivo application.properties
	@Value("${default.sender}")
	private String sender;

	//Envia o email
	@Override
	public void sendOrderConfirmationEmail(Pedido obj) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromPedido(obj);
		sendEmail(sm);
	}
	
	//Prepara o E-mail a ser enviado
	protected SimpleMailMessage prepareSimpleMailMessageFromPedido(Pedido obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getCliente().getEmail());
		sm.setFrom(sender);
		sm.setSubject("Pedido confirmado! Código: " + obj.getId());
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText(obj.toString());
		return sm;
	}
}
