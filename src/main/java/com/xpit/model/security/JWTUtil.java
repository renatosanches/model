package com.xpit.model.security;


//Classe do tipo (@Component) para injecao em outras classes com a operação gerar token generateToken(String username)
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {
	//Busca segredo do app.proprieties
	@Value("${jwt.secret}")
	private String secret;

	//Busca expiration do app.proprieties
	@Value("${jwt.expiration}")
	private Long expiration;

	public String generateToken(String username) {
		//gera token pelo Jwts.builder
		return Jwts.builder()
				//ususario
				.setSubject(username)
				//expiracao
				.setExpiration(new Date(System.currentTimeMillis() + expiration))
				//como o token sera assinado: HS512 + Segredo
				.signWith(SignatureAlgorithm.HS512, secret.getBytes())				
				.compact();
	}

}
