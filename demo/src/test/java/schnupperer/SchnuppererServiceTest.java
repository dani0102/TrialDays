package schnupperer;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import ch.ny.person.Person;
import ch.ny.schnupperer.Schnupperer;
import ch.ny.schnupperer.SchnuppererRepository;
import ch.ny.schnupperer.SchnuppererService;

@RunWith(MockitoJUnitRunner.class)
public class SchnuppererServiceTest {

	@InjectMocks
	private SchnuppererService schnuppererService;
	
	@Mock
	private SchnuppererRepository schnuppererrespository;
	
	private DataHolder<Schnupperer> dataHolder;
	
	@Before
	public void setup() {
		this.dataHolder = DataGenerators.forClass(Schnupperer.class).generate();
	}
	
	@Test
	public void findById_idExists_returnsSchnupperer() {
		var schnupperer = dataHolder.first();
		when(schnuppererRepository.findById(((Person) schnupperer).getId()))
				.thenReturn(Optional.of(schnupperer));
	}
	
	@Test
	public void findById_idDoesNotExist_returnsSchnupperer() {
		assertThat(schnuppererService.getById(223L))
				.isEmpty();
	}
	
}
