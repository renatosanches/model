package com.xpit.model.dto;

/* Back End - API REST
 * Classes DTO - Data Transfer Objetcs
 * Java + Spring Framework
 * Renato Sanches - XP IT Tecnologia 
 */

import java.io.Serializable;



import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.xpit.model.domain.Categoria;

//classe para listar todas as categorias no banco de dados - findAll
public class CategoriaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	//Anotações de Validação do Spring Framework
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=80, message="O tamanho deve ser entre 5 e 80 caracteres")
	private String nome;

	public CategoriaDTO() {
	}

	public CategoriaDTO(Categoria obj) {
		id = obj.getId();
		nome = obj.getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	

}
