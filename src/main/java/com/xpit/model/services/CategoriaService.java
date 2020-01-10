package com.xpit.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.xpit.model.domain.Categoria;
import com.xpit.model.dto.CategoriaDTO;
import com.xpit.model.repositories.CategoriaRepository;
import com.xpit.model.services.exceptions.DataIntegrityException;
import com.xpit.model.services.exceptions.ObjectNotFoundException;

/* Classe responsavel por consultar dados Repositorio : Categoria 
 * Java + Spring Boot
 * Renato Sanches - XP IT Tecnologia 
 */

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	// Efetua Busca de Categoria
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

	// Efetua Insert de Categoria
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	// Efetua update de Categoria
	public Categoria update(Categoria obj) {
		Categoria newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);

	}
	
	// Efetua Delete de Categoria
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
		}
	}
	
	// Lista todas as categorias
	public List<Categoria> findAll() {
		return repo.findAll();
	}
	
	//Implementa paginacao em categorias com spring framework
	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	// 
	public Categoria fromDTO(CategoriaDTO objDto) {
		return new Categoria(objDto.getId(), objDto.getNome());
	}

	private void updateData(Categoria newObj, Categoria obj) {
		newObj.setNome(obj.getNome());
	}
	
}
