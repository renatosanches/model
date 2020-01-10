package com.xpit.model.resources.exceptions;

/* Back End - API REST 
 * Exeception Resource- Endpoint do Controlador Rest : ValidationError = Personalizando o retorno da validacao 
 * Java + Spring Framework
 * Renato Sanches - XP IT Tecnologia 
 */


import java.util.ArrayList;
import java.util.List;
//Personalizando o retorno da validacao
public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;

	private List<FieldMessage> errors = new ArrayList<>();

	public ValidationError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addError(String fieldName, String messagem) {
		errors.add(new FieldMessage(fieldName, messagem));
	}
}
