package com.xpit.model.services;

/* Back End - API REST
 * Classe de Serviço : Cidade
 * Java + Spring Framework
 * Renato Sanches - XP IT Tecnologia 
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xpit.model.domain.Cidade;
import com.xpit.model.repositories.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repo;

	//metodo para retornar as cidades
	public List<Cidade> findByEstado(Integer estadoId) {
		return repo.findCidades(estadoId);
	}
}