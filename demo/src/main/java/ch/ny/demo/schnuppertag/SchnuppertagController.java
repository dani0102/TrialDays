package ch.ny.demo.schnuppertag;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ch.ny.demo.schnupperer.Schnupperer;

@RestController
@RequestMapping("/schnuppertag")
public class SchnuppertagController {

	private SchnuppertagServiceable service;
	private SchnuppertagMapper mapper;
	
	@Autowired
	public SchnuppertagController(SchnuppertagServiceable service, SchnuppertagMapper mapper) {
		this.service = service;
		this.mapper = mapper;
	}
	
	@GetMapping({"", "/"})
	public @ResponseBody ResponseEntity<Iterable<SchnuppertagDTO>> getAll() {
		var result = this.service.getAll();
		var toReturn = this.mapper.toListDTO(result);
		
		return new ResponseEntity<>(toReturn, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<SchnuppertagDTO> getById(@PathVariable long id) {
		var result = this.service.getById(id);
		var toReturn = mapper.toDTO(result.get());
		
		if(result.isPresent()) {
			return new ResponseEntity<>(toReturn, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	// By posting the schnupperer_id to this endpoint
	// you can add the shcnupperer to the participants array
	@PostMapping("/{schnuppertagId}")
	public ResponseEntity<?> assignSchnuppererToSchnuppertag(@PathVariable long schnuppertagId, @RequestBody Schnupperer schnupperer){
		this.service.addSchnupperer(schnupperer.getId(), schnuppertagId);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PostMapping({"", "/"})
	public ResponseEntity<?> createSchnuppertag(@RequestBody @Valid Schnuppertag valueToAdd) {
		this.service.createSchnuppertag(valueToAdd);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
}
