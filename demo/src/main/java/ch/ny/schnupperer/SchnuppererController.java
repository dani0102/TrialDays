package ch.ny.schnupperer;

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
@RequestMapping("/berufsbildner")
public class SchnuppererController {

	private SchnuppererServiceable service;
	
	@Autowired
	public SchnuppererController(SchnuppererServiceable service) {
		this.service = service;
	}
	
	@GetMapping({"", "/"})
	public @ResponseBody ResponseEntity<Iterable<Schnupperer>> getAll() {
		var toReturn = this.service.getAll();
		
		return new ResponseEntity<>(toReturn, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<Schnupperer> getById(@PathVariable long id) {
		var toReturn = this.service.getById(id);
		
		if(toReturn.isPresent()) {
			return new ResponseEntity<Schnupperer>(toReturn.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping({"", "/"})
	public ResponseEntity<?> createBerufsbildner(@RequestBody Schnupperer valueToAdd) {
		this.service.createSchnupperer(valueToAdd);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
}
