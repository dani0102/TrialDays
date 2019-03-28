package ch.ny.demo.schnupperer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import ch.ny.data.DataGenerators;
import ch.ny.data.DataHolder;
import ch.ny.schnupperer.Schnupperer;
import ch.ny.schnupperer.SchnuppererController;
import ch.ny.schnupperer.SchnuppererMapper;
import ch.ny.schnupperer.SchnuppererService;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = SchnuppererController.class, includeFilters = {
		@Filter(classes = {SchnuppererMapper.class},
				type = FilterType.ASSIGNABLE_TYPE)
})
public class SchnuppererControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private SchnuppererService schnuppererService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private SchnuppererMapper schnuppererMapper;
	
	private DataHolder<Schnupperer> dataHolder;
	
	@Before
	public void setup() {
		this.dataHolder = DataGenerators.forClass(Schnupperer.class).generate();
	}
	
	@Test
	public void test() throws Exception {
		when(schnuppererService.getAll()).thenReturn(dataHolder.asList());
		
		var expectedJson = objectMapper.writeValueAsString(
				schnuppererMapper.toListDTO(dataHolder.asList())
		);
		
		
		
		mockMvc.perform(get("/schnupperer"))
				.andExpect(status().isOk())
				.andExpect(content().json(expectedJson));
	}

}
