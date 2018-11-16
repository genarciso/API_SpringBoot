package com.example.api.config;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.api.model.UserAPI;
import com.fasterxml.jackson.databind.ObjectMapper;

import static com.example.api.config.SecurityConstants.*;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
public class JWTAutenticao extends UsernamePasswordAuthenticationFilter{
	private AuthenticationManager authentication;

	public JWTAutenticao(AuthenticationManager authentication) {
		this.authentication = authentication;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
		try {
			UserAPI user = new ObjectMapper().readValue(request.getInputStream(), UserAPI.class);
			return this.authentication
					.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		}
		catch(IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		String username = ((User) authResult.getPrincipal()).getUsername();
		String token = Jwts.builder()
				.setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME ))
				.signWith(SignatureAlgorithm.HS512, SECRET)
				.compact();
		response.addHeader(HEADER_STRING, TOKEN_PREFIX+token);
	}
	

}
