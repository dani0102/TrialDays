package ch.ny.demo.ort;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import ch.ny.demo.data.DataGenerators;
import ch.ny.demo.data.DataHolder;

@RunWith(MockitoJUnitRunner.class)
public class OrtServiceTest {

	@InjectMocks
	private OrtService ortService;
	
	@Mock
	private OrtRepository ortRepository;
	
	private DataHolder<Ort> dataHolder;
	
	@Before
	public void setup() {
		this.dataHolder = DataGenerators.forClass(Ort.class).generate();
	}
	
	@Test
	public void findById_idExists_returnsSchnupperer() {
		var ort = dataHolder.first();
		when(ortRepository.findById((ort).getId()))
				.thenReturn(Optional.of(ort));
		
		assertThat(ortService.getById(ort.getId()))
			.isPresent()
			.contains(ort);
	}
	
	@Test
	public void findById_idDoesNotExist_returnsNothing() {
		assertThat(ortService.getById(223L))
				.isEmpty();
	}
	
}
