package com.xpit.model.repositories;

/* Back End - API REST
 * Interface Camada de Acesso a dados Repositorio : Estado
 * Java + Spring Framework
 * Renato Sanches - XP IT Tecnologia 
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xpit.model.domain.Estado;



@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{
	
	

}
