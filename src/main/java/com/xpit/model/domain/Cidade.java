package com.xpit.model.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cidade implements Serializable {
	private static final long serialVersionUID = 1L;
	// A anotação @Id informa qual campo de uma entidade representa a chave primária
	// da respectiva tabela no banco de dados
	@Id
	// A anotação @GeneratedValue, deve ser declarada quando a geração do valor da
	// chave-primária é de responsabilidade do banco de dados.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;

	// Proteger contra serialização Json cíclica - Permitindo que cidade carregem
	// seu estado e nao o contrario por isso em estado usa-se @JsonBackReference
	// @JsonManagedReference - Retirou

// Cidade tem um estado (papel), por isso nao é list	
//	O relacionamento @ManyToOne informa que existem muitos registros de uma entidade (estado) associados a um registro da entidade(estado).
	@ManyToOne
	// chave estrangeira estado_id na tabela cidade no banco de dados
//	A anotação @JoinColumn indica que a classe na qual você está utilizando-a é a dona ou o lado forte do relacionamento. 
//	Isso apenas adciona uma coluna estrangeira ao lado forte.	
	@JoinColumn(name = "estado_id")
	private Estado estado;

//	Construtor vazio
	public Cidade() {

	}

	public Cidade(Integer id, String nome, Estado estado) {
		super();
		this.id = id;
		this.nome = nome;
		this.estado = estado;
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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
