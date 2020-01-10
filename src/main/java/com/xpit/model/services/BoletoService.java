package com.xpit.model.services;

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
