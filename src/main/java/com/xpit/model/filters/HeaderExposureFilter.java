package com.xpit.model.filters;

/* Back End - API REST
 * Filtro para Expor o header location nas respostas para que o app front end Angular consiga ler o cabecalho
 * Através de PUBLIC_MATCHERS o que etsa liberado
 * Java + Spring Framework
 * Renato Sanches - XP IT Tecnologia 
 */

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class HeaderExposureFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	
	@Override
	//expondo o cabecalho location nas respostas
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletResponse res = (HttpServletResponse) response;
		res.addHeader("access-control-expose-headers", "location");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}
}