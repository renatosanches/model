package com.xpit.model.resources.exceptions;

/* Back End - API REST 
 * Exeception Resource- Endpoint do Controlador Rest FieldMessage 
 * Java + Spring Framework
 * Renato Sanches - XP IT Tecnologia 
 */

import java.io.Serializable;

//Personalizando o retorno da validacao
public class FieldMessage implements Serializable {
	private static final long serialVersionUID = 1L;

	private String fieldName;
	private String message;

	public FieldMessage() {
	}

	public FieldMessage(String fieldName, String message) {
		super();
		this.fieldName = fieldName;
		this.message = message;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
