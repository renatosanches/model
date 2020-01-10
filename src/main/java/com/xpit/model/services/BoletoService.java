package com.xpit.model.services;

/* Back End - API REST 
 * Service - Camada de Servicos do Controlador Rest
 * Classe responsavel por Inserir a data de vencimento 7 dias pagamento com boleto
 * Java + Spring Framework
 * Renato Sanches - XP IT Tecnologia 
 */

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.xpit.model.domain.PagamentoComBoleto;
//Insere a data de vencimento 7 dias
@Service
public class BoletoService {
	public void preencherPagamentoComBoleto(PagamentoComBoleto pagto, Date instanteDoPedido) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(instanteDoPedido);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		pagto.setDataVencimento(cal.getTime());
	}
}
