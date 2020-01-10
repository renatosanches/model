package com.xpit.model.services.exceptions;

//Tratamento de erros excessoes e erros do sistema 

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	// Construtor reaproveitando a infraestrutura de excecoes da linguagem Java
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	
	public ObjectNotFoundException(String msg, Throwable cause) {
		super(msg);
	}
	
}
