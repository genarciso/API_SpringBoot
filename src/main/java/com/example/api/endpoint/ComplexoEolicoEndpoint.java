package com.example.api.endpoint;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.model.ComplexoEolico;
import com.example.api.repository.ComplexoEolicoRepository;

@RestController
@RequestMapping("complexo_eolico")
public class ComplexoEolicoEndpoint {
	private final ComplexoEolicoRepository complexoEolicoDAO;

	@Autowired
	public ComplexoEolicoEndpoint(ComplexoEolicoRepository complexoEolicoDao) {
		this.complexoEolicoDAO = complexoEolicoDao;
	}

	@GetMapping
	public ResponseEntity<?> listAll(Pageable pageable) {
		return new ResponseEntity<>(complexoEolicoDAO.findAll(pageable), HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<?> getComplexoEolicoById(@PathVariable Long id) {
		Optional<ComplexoEolico> complexo = complexoEolicoDAO.findById(id);
		if (complexo == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(complexo, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> createcomplexoEolico(@RequestBody ComplexoEolico complexoEolico) {
		return new ResponseEntity<>(complexoEolicoDAO.save(complexoEolico), HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deletecomplexoEolico(@PathVariable Long id) {
		complexoEolicoDAO.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<?> updatecomplexoEolico(@RequestBody ComplexoEolico complexoEolico) {
		complexoEolicoDAO.save(complexoEolico);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
