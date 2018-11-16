package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.model.ComplexoEolico;
import com.example.api.model.UserAPI;

public interface UserAPIRepository extends JpaRepository<UserAPI, Long>{
	UserAPI findByUsername(String username);
}
