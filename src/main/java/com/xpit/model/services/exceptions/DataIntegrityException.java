package com.xpit.model.services.exceptions;

/* Back End - API REST 
 * Exceptions Service - Camada de Servicos do Controlador Rest 
 * Classe responsavel por capturar Exceptions 
 * Java + Spring Framework
 * Renato Sanches - XP IT Tecnologia 
 */

public class DataIntegrityException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataIntegrityException(String msg) {
		super(msg);
	}

	public DataIntegrityException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
