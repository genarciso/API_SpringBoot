package com.example.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.api.model.ComplexoEolico;
import com.example.api.model.ParqueEolico;

@Repository
public interface ParqueEolicoRepository extends JpaRepository<ParqueEolico, Long> {
	List<ParqueEolico> findByComplexoId(Long complexoId);
}
