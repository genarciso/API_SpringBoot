package com.example.api.config;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.api.model.UserAPI;
import com.example.api.repository.UserAPIRepository;

@Component
public class CustomUserDetails implements UserDetailsService{
	private final UserAPIRepository userAPIRepository;

	public CustomUserDetails(UserAPIRepository userAPIRepository) {
		this.userAPIRepository = userAPIRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserAPI user = Optional.ofNullable(userAPIRepository.findByUsername(username)).orElseThrow(()-> new UsernameNotFoundException("Usuario não achado"));
		List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER");
		return new User(user.getUsername(), user.getPassword(), authorityListUser);
	}
		
	
}
