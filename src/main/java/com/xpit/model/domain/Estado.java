package com.xpit.model.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;
	// A anotação @Id informa qual campo de uma entidade representa a chave primária
	// da respectiva tabela no banco de dados
	@Id
	// A anotação @GeneratedValue, deve ser declarada quando a geração do valor da
	// chave-primária é de responsabilidade do banco de dados.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	//Proteger contra serialização Json cíclica - Permitindo que cidade carregem seu estado e nao o contrario por isso em estado usa-se @JsonBackReference
	@JsonIgnore
//	Lista de Cidades do Estado
//   Mapeamento reverso de cidade para estado @Onetomany
	@OneToMany(mappedBy = "estado")
	private List<Cidade> cidades = new ArrayList<>();

	//Contrutor vazio
	public Estado() {

	}

	public Estado(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;

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

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
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
		Estado other = (Estado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
