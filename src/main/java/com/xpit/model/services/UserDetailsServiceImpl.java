package com.xpit.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.xpit.model.domain.Cliente;
import com.xpit.model.repositories.ClienteRepository;
import com.xpit.model.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private ClienteRepository repo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//		implementa Busca por e-mail em Clientes
		Cliente cli = repo.findByEmail(email);
		if (cli == null) {
//			Se nao encontra, gera excecao do Spring
			throw new UsernameNotFoundException(email);
		}
		return new UserSS(cli.getId(), cli.getEmail(), cli.getSenha(), cli.getPerfis());
	}
}
