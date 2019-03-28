package ch.ny.demo.berufsbildner;

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

//subcollection of controller
//automatically has @Component @Responsebody
@RestController
@RequestMapping("/berufsbildner")
public class BerufsbildnerController {

	private BerufsbildnerServiceable service;
	private BerufsbildnerMapper mapper;
	
	//automatisch die Objekte die man braucht instanzieren -> sorgt für dependency injection
	@Autowired
	public BerufsbildnerController(BerufsbildnerServiceable service, BerufsbildnerMapper mapper) {
		this.service = service;
		this.mapper = mapper;
	}
	
	//endpoint für HTTP request get
	@GetMapping({"", "/"})
	public @ResponseBody ResponseEntity<Iterable<BerufsbildnerDTO>> getAll() {
		var result = this.service.getAll();
		var toReturn = mapper.toListDTO(result);
		
		return new ResponseEntity<>(toReturn, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<BerufsbildnerDTO> getById(@PathVariable long id) {
		var result = this.service.getById(id);
		var toReturn = this.mapper.toDTO(result.get());
		
		if(result.isPresent()) {
			return new ResponseEntity<>(toReturn, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//@RequestBody 
	@PostMapping({"", "/"})
	public ResponseEntity<?> createBerufsbildner(@RequestBody @Valid Berufsbildner valueToAdd) {
		System.out.println(valueToAdd.getFirstName());
		this.service.createBerufsbildner(valueToAdd);
		
		return new ResponseEntity<>(valueToAdd, HttpStatus.CREATED);
	}
	
}
