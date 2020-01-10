package com.xpit.model.repositories;

/* Interface Camada de Acesso a dados Repositorio : Pagamento 
 * Java + Spring Boot
 * Renato Sanches - XP IT Tecnologia 
 */ 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.xpit.model.domain.Pagamento;



@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{

}
