package ch.ny.fachrichtung;

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
@RequestMapping("/fachrichtung")
public class FachrichtungController {

	private FachrichtungServiceable service;
	
	@Autowired
	public FachrichtungController(FachrichtungServiceable service) {
		this.service = service;
	}
	
	@GetMapping({"", "/"})
	public @ResponseBody ResponseEntity<Iterable<Fachrichtung>> getAll() {
		Iterable<Fachrichtung> toReturn = service.getAll();
		
		return new ResponseEntity<>(toReturn, HttpStatus.OK);
	}
	
	@GetMapping({"/{id}"})
	public @ResponseBody ResponseEntity<Fachrichtung> getById(@PathVariable long id){
		var toReturn = this.service.getById(id);
		
		if(toReturn.isPresent()) {
			System.out.println("found");
			return new ResponseEntity<Fachrichtung>(toReturn.get(), HttpStatus.OK);
		} else {
			System.out.println("not found");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping({"", "/"})
	public ResponseEntity<?> createFachrichtung(@RequestBody Fachrichtung valueToAdd){
		service.createFachrichtung(valueToAdd);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
}
