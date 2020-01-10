package com.xpit.model.repositories;

/* Back End - API REST
 * Interface Camada de Acesso a dados Repositorio : Cliente
 * Java + Spring Framework
 * Renato Sanches - XP IT Tecnologia 
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xpit.model.domain.Cliente;



@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
	// implementa rotina que efetua busca do e-mail para verificar duplicidade no ClienteInsertValidator 
	@Transactional(readOnly=true)
	Cliente findByEmail(String email);

}
