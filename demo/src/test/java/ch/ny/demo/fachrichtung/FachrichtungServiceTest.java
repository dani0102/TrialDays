package ch.ny.demo.fachrichtung;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import ch.ny.fachrichtung.FachrichtungRepository;
import ch.ny.fachrichtung.FachrichtungService;
import ch.ny.data.DataHolder;
import ch.ny.fachrichtung.Fachrichtung;

@RunWith(MockitoJUnitRunner.class)
public class FachrichtungServiceTest {

	@InjectMocks
	private FachrichtungService fachrichtungService;
	
	@Mock
	private FachrichtungRepository fachrichtungRepository;

	private DataHolder<Fachrichtung> dataHolder;
	
	@Before
	public void setup() {
		
	}
	
	@Test
	public void findById_idExists_returnsFachrichtung() {
		//Arrange
		var fachrichtung = dataHolder.first();
		when(fachrichtungRepository.findById(fachrichtung.getId()))
			.thenReturn(Optional.of(fachrichtung));
		
		
	}
	
}
