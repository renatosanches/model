package com.xpit.model.repositories;

/* Interface Camada de Acesso a dados Repositorio : Endereco 
 * Java + Spring Boot
 * Renato Sanches - XP IT Tecnologia 
 */ 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.xpit.model.domain.Endereco;



@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{

}
