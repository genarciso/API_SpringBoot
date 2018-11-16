package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.api.model.ComplexoEolico;

@Repository
public interface ComplexoEolicoRepository extends JpaRepository<ComplexoEolico, Long>{

}
