package ch.ny.demo.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements PersonServiceable{

	private PersonRepository repository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	/**
	 * @param repository
	 */
	@Autowired
	public PersonService(@Qualifier("personRepository") PersonRepository repository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.repository = repository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	public Person findById(Long id) {
		return repository.findById(id).get();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Person user = findByUsername(username);
		
		if (user == null) { throw new UsernameNotFoundException("User could not be found"); }
		return new UserDetailsImpl(user);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Person findByUsername(String name) {
		Person user = repository.findByUsername(name);
		return user;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteByUsername(String name) {
		repository.deleteByUsername(name);
	}

}
