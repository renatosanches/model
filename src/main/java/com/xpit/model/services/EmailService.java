package com.xpit.model.services;

import javax.mail.internet.MimeMessage;

/* Back End - API REST 
 * Service - Camada de Servicos do Controlador Rest 
 * Interface (padrão Strategy) - Responsavel pelos servicos de email (operacões oferecidas do servico de e-mail) 
 * Java + Spring Framework
 * Renato Sanches - XP IT Tecnologia 
 */

import org.springframework.mail.SimpleMailMessage;

import com.xpit.model.domain.Cliente;
import com.xpit.model.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
    //Email com texto plano
	void sendEmail(SimpleMailMessage msg);
	
	void sendOrderConfirmationHtmlEmail(Pedido obj);
	//Email HTML
	void sendHtmlEmail(MimeMessage msg);
	
	void sendNewPasswordEmail(Cliente cliente, String newPass);
	
}
