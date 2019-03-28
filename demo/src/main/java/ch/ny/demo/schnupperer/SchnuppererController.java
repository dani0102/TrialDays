package ch.ny.demo.schnupperer;

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

@RestController
@RequestMapping("/schnupperer")
public class SchnuppererController {

	private SchnuppererServiceable service;
	private SchnuppererMapper mapper;
	
	@Autowired
	public SchnuppererController(SchnuppererServiceable service, SchnuppererMapper mapper) {
		this.service = service;
		this.mapper = mapper; 
	}
	
	@GetMapping({"", "/"})
	public @ResponseBody ResponseEntity<Iterable<SchnuppererDTO>> getAll() {
		var result = this.service.getAll();
		var toReturn = mapper.toListDTO(result);
		
		return new ResponseEntity<>(toReturn, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<SchnuppererDTO> getById(@PathVariable long id) {
		var result = this.service.getById(id);
		var toReturn = mapper.toDTO(result.get());
		
		if(result.isPresent()) {
			return new ResponseEntity<>(toReturn, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping({"", "/"})
	public ResponseEntity<?> createBerufsbildner(@RequestBody @Valid Schnupperer valueToAdd) {
		this.service.createSchnupperer(valueToAdd);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
}
