package ch.ny.demo.berufsbildner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import ch.ny.data.DataGenerators;
import ch.ny.data.DataHolder;

@RunWith(MockitoJUnitRunner.class)
public class BerufsbildnerServiceTest {

	@InjectMocks
	private BerufsbildnerService berufsbildnerService;
	
	@Mock
	private BerufsbildnerRepository berufsbildnerRepository;
	
	private DataHolder<Berufsbildner> dataHolder;
	
	@Before
	public void setup() {
		this.dataHolder = DataGenerators.forClass(Berufsbildner.class).generate();
	}
	
	@Test
	public void findById_idExists_returnsBerufsbildner() {
		var berufsbildner = dataHolder.first();
		when(berufsbildnerRepository.findById(((Berufsbildner) berufsbildner).getId()))
				.thenReturn(Optional.of(berufsbildner));
	}
	
	@Test
	public void findById_idDoesNotExist_returnsNothing() {
		assertThat(berufsbildnerService.getById(223L))
				.isEmpty();
	}
	
}
