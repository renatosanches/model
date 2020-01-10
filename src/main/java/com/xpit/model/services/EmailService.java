package com.xpit.model.services;

/* Back End - API REST 
 * Service - Camada de Servicos do Controlador Rest 
 * Interface (padrão Strategy) - Responsavel pelos servicos de email (operacões oferecidas do servico de e-mail) 
 * Java + Spring Framework
 * Renato Sanches - XP IT Tecnologia 
 */

import org.springframework.mail.SimpleMailMessage;

import com.xpit.model.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);

	void sendEmail(SimpleMailMessage msg);
	
}
