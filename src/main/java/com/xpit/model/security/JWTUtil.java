package com.xpit.model.security;


//Classe do tipo (@Component) para injecao em outras classes com a operação gerar token generateToken(String username)
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
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
	//Testa se o token é valido
	public boolean tokenValido(String token) {
//		obtem os clains (revindicações) a partir de um token
		Claims claims = getClaims(token);
		if (claims != null) {
			String username = claims.getSubject();
			Date expirationDate = claims.getExpiration();
			Date now = new Date(System.currentTimeMillis());
			if (username != null && expirationDate != null && now.before(expirationDate)) {
				return true;
			}
		}
		return false;
	}
    //Pega usuario a partir de um token valido
	public String getUsername(String token) {
		Claims claims = getClaims(token);
		if (claims != null) {
			return claims.getSubject();
		}
		return null;
	}

	private Claims getClaims(String token) {
		try {
			return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
		}
		catch (Exception e) {
			return null;
		}
	}
	

}
