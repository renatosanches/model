package com.xpit.model.services;

/* Back End - API REST
 * Classe de Serviço : Estado
 * Java + Spring Framework
 * Renato Sanches - XP IT Tecnologia 
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xpit.model.domain.Estado;
import com.xpit.model.repositories.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repo;

	//metodo para retornar os estados
	public List<Estado> findAll() {
		return repo.findAllByOrderByNome();
	}
}
