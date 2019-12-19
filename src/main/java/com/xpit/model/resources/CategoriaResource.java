package com.xpit.model.resources;
/* API REST - Categorias
 * Java + Spring Boot
 * Renato Sanches - XP IT Tecnologia 
 */ 

import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.xpit.model.domain.Categoria;

@RestController
//endereço do endpoint REST 
@RequestMapping(value="/categorias")
public class CategoriaResource {
	// requisicao basica Get
	@RequestMapping(method=RequestMethod.GET)
	//get ira retorna a List<Categoria>
	public List<Categoria> listar() {
		// instanciação das categorias 
		Categoria cat1 = new Categoria(1,"Automotivo");
		Categoria cat2 = new Categoria(2,"Brinquedos e Bebê");
		Categoria cat3 = new Categoria(3,"Informática e Acessórios");
		Categoria cat4 = new Categoria(4,"Eletrodomésticos");
		Categoria cat5 = new Categoria(5,"Eletrônicos");
		Categoria cat6 = new Categoria(6,"Celulares e Tablets");
		Categoria cat7 = new Categoria(7,"Games");
		Categoria cat8 = new Categoria(7,"Livros");
		
		//Criação da lista de catedorias lista
		List<Categoria> lista = new ArrayList<>();
//		Adicionando os objetos na lista 
		lista.add(cat1);
		lista.add(cat2);
		lista.add(cat3);
		lista.add(cat4);
		lista.add(cat5);
		lista.add(cat6);
		lista.add(cat7);
		lista.add(cat8);
//		Retorna no formato JSON
		return lista;
	}

}
