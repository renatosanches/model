package com.xpit.model.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/* Back End - API REST
 * Interface Camada de Acesso a dados Repositorio : Pedido
 * Java + Spring Framework
 * Renato Sanches - XP IT Tecnologia 
 */ 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xpit.model.domain.Cliente;
import com.xpit.model.domain.Pedido;



@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
	
//	consulta de Pedido por Cliente na camada de acesso a dados
	@Transactional(readOnly=true)
	Page<Pedido> findByCliente(Cliente cliente, Pageable pageRequest);

}
