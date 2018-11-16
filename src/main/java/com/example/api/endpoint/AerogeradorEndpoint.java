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

import com.example.api.model.Aerogerador;
import com.example.api.repository.AerogeradorRepository;
import com.example.api.repository.ParqueEolicoRepository;

@RestController
@RequestMapping("complexo_eolico/{complexo_id}/parque_eolico/{parque_id}/aerogerador")
public class AerogeradorEndpoint {
	private final AerogeradorRepository aerogeradorDAO;
	private final ParqueEolicoRepository parqueEolicoDAO;
	@Autowired
	public AerogeradorEndpoint(AerogeradorRepository aerogeradorDao,ParqueEolicoRepository parqueEolicoDAO) {
		this.aerogeradorDAO = aerogeradorDao;
		this.parqueEolicoDAO = parqueEolicoDAO;
	}
	
	@GetMapping
	public ResponseEntity<?> getAerogeradorByParque(@PathVariable Long parque_id, Pageable pageable){
		return new ResponseEntity<>(aerogeradorDAO.findByParqueId(parque_id),HttpStatus.OK);
	}
	@GetMapping(path="/{id}")
	public ResponseEntity<?> getaerogeradorById(@PathVariable Long id){
		Optional<Aerogerador> aerogerador = aerogeradorDAO.findById(id);
		if(aerogerador == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(aerogerador,HttpStatus.OK);
	}
	@PostMapping
	public Aerogerador createAerogerador(@RequestBody Aerogerador aerogerador, @PathVariable Long parque_id){
		return parqueEolicoDAO.findById(parque_id).map(parque -> {
			aerogerador.setParque(parque);
			return aerogeradorDAO.save(aerogerador);
		}).orElseThrow(()-> new ResourceNotFoundException("Parque e/ou Complexo Eolico não encotrado para esse id"));
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<?> deleteaerogerador(@PathVariable Long id){
		aerogeradorDAO.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@PutMapping
	public ResponseEntity<?> updateaerogerador(@RequestBody Aerogerador aerogerador){
		aerogeradorDAO.save(aerogerador);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
