package com.xpit.model.repositories;

/* Interface Camada de Acesso a dados Repositorio : ItemPedido 
 * Java + Spring Boot
 * Renato Sanches - XP IT Tecnologia 
 */ 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.xpit.model.domain.ItemPedido;



@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer>{

}
