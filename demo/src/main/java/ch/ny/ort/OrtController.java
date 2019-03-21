package ch.ny.ort;

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
@RequestMapping("/ort")
public class OrtController {

	private OrtServiceable service;
	
	@Autowired
	public OrtController(OrtServiceable service) {
		this.service = service;
	}
	
	@GetMapping({"", "/"})
	public @ResponseBody ResponseEntity<Iterable<Ort>> getAll() {
		var toReturn = this.service.getAll();
		
		return new ResponseEntity<>(toReturn, HttpStatus.OK);
	}
	
	@GetMapping({"/{id}"})
	public @ResponseBody ResponseEntity<Ort> getById(@PathVariable long id){
		var toReturn = this.service.getById(id);
		
		if(toReturn.isPresent()) {
			return new ResponseEntity<Ort>(toReturn.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping({"", "/"})
	public ResponseEntity<?> createOrt(@RequestBody Ort valueToAdd){
		this.service.createOrt(valueToAdd);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
}
