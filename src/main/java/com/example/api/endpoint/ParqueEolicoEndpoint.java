package com.example.api.endpoint;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
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

import com.example.api.model.ParqueEolico;
import com.example.api.repository.ComplexoEolicoRepository;
import com.example.api.repository.ParqueEolicoRepository;

@RestController
@RequestMapping("complexo_eolico/{complexo_id}/parque_eolico")
public class ParqueEolicoEndpoint {
	private final ParqueEolicoRepository parqueEolicoDAO;
	private final ComplexoEolicoRepository complexoEolicoDAO;
	@Autowired
	public ParqueEolicoEndpoint(ComplexoEolicoRepository complexoEolicoDAO,ParqueEolicoRepository parqueEolicoDao) {
		this.parqueEolicoDAO = parqueEolicoDao;
		this.complexoEolicoDAO = complexoEolicoDAO;
	}
	
	@GetMapping
	public ResponseEntity<?> getParqueEolicoByComplexoEolicoId(@PathVariable Long complexo_id, Pageable pageable){
		return new ResponseEntity<>(parqueEolicoDAO.findByComplexoId(complexo_id),HttpStatus.OK);
	}
	@GetMapping(path="/{id}")
	public ResponseEntity<?> getParqueEolicoById(@PathVariable Long id){
		Optional<ParqueEolico> parque = parqueEolicoDAO.findById(id);
		if(parque == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(parque,HttpStatus.OK);
	}
	@PostMapping
	public ParqueEolico createParqueEolico(@RequestBody ParqueEolico parqueEolico, @PathVariable Long complexo_id){
		return complexoEolicoDAO.findById(complexo_id).map(complexo -> {
			parqueEolico.setComplexoEolico(complexo);
			return parqueEolicoDAO.save(parqueEolico);
		}).orElseThrow(()-> new ResourceNotFoundException());
	}
	@DeleteMapping(path="/{id}")
	public ResponseEntity<?> deleteParqueEolico(@PathVariable Long id){
		parqueEolicoDAO.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@PutMapping
	public ResponseEntity<?> updateParqueEolico(@RequestBody ParqueEolico parqueEolico, @PathVariable Long complexo_id){
		if(!complexoEolicoDAO.existsById(complexo_id)){
			return new ResponseEntity<>("Não encontrado complexo eolico", HttpStatus.NO_CONTENT);
		}
		parqueEolicoDAO.save(parqueEolico);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
