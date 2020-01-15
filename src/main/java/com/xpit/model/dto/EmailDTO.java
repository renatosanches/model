package com.xpit.model.dto;

/* Back End - API REST
 * Classes DTO - Data Transfer Objetcs - Email para Implementacao de Esqueci a senha
 * Java + Spring Framework
 * Renato Sanches - XP IT Tecnologia 
 */


import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class EmailDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotEmpty(message="Preenchimento obrigatório")
	@Email(message="Email inválido")
	private String email;

	public EmailDTO() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
