package com.example.api.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PassEncorder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		System.out.println(bc.encode("root"));
	}

}
