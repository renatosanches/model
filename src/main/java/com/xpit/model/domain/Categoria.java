package com.xpit.model.domain;

/* Back End - API REST
 * Java + Spring Framework
 * Renato Sanches - XP IT Tecnologia 
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


//@Entity informa que uma classe representa uma entidade e que seus objetos devem ser persistidos no banco de dados.
@Entity
public class Categoria implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	
	//A anotação @Id informa qual campo de uma entidade representa a chave primária da respectiva tabela no banco de dados
	@Id
	//A anotação @GeneratedValue, deve ser declarada quando a geração do valor da chave-primária é de responsabilidade do banco de dados.
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
//	 @JsonManagedReferences e JsonBackReferences são usados ​​para exibir objetos com o relacionamento pai-filho.
//	 Proteção para referência cíclica na serialização Json
//	 @JsonManagedReferences é usado para se referir ao objeto pai e 
//	 @JsonBackReferences é usado para marcar objetos filho.
//   São usados ​​para resolver a Infinite recursion (StackOverflowError) usados ​​para manipular referências circulares
	
	// Referencia gerenciada pelo Json - relacionamentos bidirecionais em Jackson
	// Evitar problema de recursão infinita do JSON (relacionamento muito para muitos)
	// @JsonManagedReference Nao precisa
	//A Anotação @ManyToMany serve para lidar com relacionamentos muitos para muitos usando JPA
	@ManyToMany(mappedBy = "categorias")
	private List<Produto> produtos = new ArrayList<>();
	
	public Categoria () {
		
	}

	public Categoria(Integer id, String nome) {
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
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
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
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	

}
