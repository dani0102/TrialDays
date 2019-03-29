package ch.ny.demo.schnuppertag;

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
public class SchnuppertagServiceTest {

	@InjectMocks
	private SchnuppertagService schnuppertagService;
	
	@Mock
	private SchnuppertagRepository schnuppertagRepository;
	
	private DataHolder<Schnuppertag> dataHolder;
	
	@Before
	public void setup() {
		this.dataHolder = DataGenerators.forClass(Schnuppertag.class).generate();
	}
	
	@Test
	public void findById_idExists_returnsSchnuppertag() {
		var schnuppertag = dataHolder.first();
		when(schnuppertagRepository.findById(( schnuppertag).getId()))
				.thenReturn(Optional.of(schnuppertag));
	}
	
	@Test
	public void findById_idDoesNotExist_returnsNothing() {
		assertThat(schnuppertagService.getById(223L))
				.isEmpty();
	}
	
}
