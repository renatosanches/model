package com.xpit.model.services.exceptions;

/* Back End - API REST 
 * Exceptions Service - Camada de Servicos do Controlador Rest 
 * Classe responsavel por Tratamento de erros excessoes e erros do sistema 
 * Java + Spring Framework
 * Renato Sanches - XP IT Tecnologia 
 */

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	// Construtor reaproveitando a infraestrutura de excecoes do Java
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	
	public ObjectNotFoundException(String msg, Throwable cause) {
		super(msg);
	}
	
}
