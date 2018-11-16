package com.example.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.api.model.Aerogerador;

@Repository
public interface AerogeradorRepository extends JpaRepository<Aerogerador, Long>{
	List<Aerogerador> findByParqueId(Long parqueId);
}
