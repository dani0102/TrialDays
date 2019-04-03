package ch.ny.demo.schnuppertag;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.ny.demo.schnupperer.Schnupperer;
import ch.ny.demo.schnupperer.SchnuppererRepository;

@Service
public class SchnuppertagService implements SchnuppertagServiceable {

	private SchnuppertagRepository repository;
	private SchnuppererRepository schnuppererRepo;
	
	@Autowired
	public SchnuppertagService(SchnuppertagRepository repository, SchnuppererRepository schnuppererRepo) {
		this.repository = repository;
		this.schnuppererRepo = schnuppererRepo;
	
	}
	
	@Override
	public Optional<Schnuppertag> getById(Long id) {
		return this.repository.findById(id);
	}

	@Override
	public List<Schnuppertag> getAll() {
		return repository.findAll();
	}

	@Override
	public void createSchnuppertag(Schnuppertag schnuppertag) {
		repository.save(schnuppertag);
	}

	@Override
	public void addSchnupperer(long schnuppererId, long schnuppertagId) {
		var schnupperer = this.schnuppererRepo.findById(schnuppererId).get();
		var schnuppertag = this.repository.findById(schnuppertagId).get();
		
		if(schnuppertag.getParticipants().size() < schnuppertag.getLimit()) {
			schnuppertag.addParticipant((Schnupperer) schnupperer);
			repository.save(schnuppertag);	
		}
	}

}