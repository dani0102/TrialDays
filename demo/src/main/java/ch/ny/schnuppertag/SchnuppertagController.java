package ch.ny.schnuppertag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schnuppertag")
public class SchnuppertagController {

	private SchnuppertagServiceable service;
	
	@Autowired
	public SchnuppertagController(SchnuppertagServiceable service) {
		this.service = service;
	}
	
	@GetMapping({"", "/"})
	public @ResponseBody ResponseEntity<Iterable<Schnuppertag>> getAll() {
		var toReturn = this.service.getAll();
		
		return new ResponseEntity<>(toReturn, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<Schnuppertag> getById(@PathVariable long id) {
		var toReturn = this.service.getById(id);
		
		if(toReturn.isPresent()) {
			return new ResponseEntity<Schnuppertag>(toReturn.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping({"", "/"})
	public ResponseEntity<?> createBerufsbildner(@RequestBody Schnuppertag valueToAdd) {
		this.service.createSchnuppertag(valueToAdd);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
}
