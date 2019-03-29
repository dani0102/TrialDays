package ch.ny.demo.ort;

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

import ch.ny.demo.data.DataGenerators;
import ch.ny.demo.data.DataHolder;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = OrtController.class, includeFilters = {
		@Filter(classes = {OrtMapper.class},
				type = FilterType.ASSIGNABLE_TYPE)
})
public class OrtControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private OrtServiceable ortService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private OrtMapper ortMapper;
	
	private DataHolder<Ort> dataHolder;
	
	@Before
	public void setup() {
		this.dataHolder = DataGenerators.forClass(Ort.class).generate();
	}
	
	@Test
	public void test() throws Exception {
		/*when(ortService.getAll()).thenReturn(dataHolder.asList());
		
		var expectedJson = objectMapper.writeValueAsString(
				ortMapper.toListDTO(dataHolder.asList())
		);
		
		
		
		mockMvc.perform(get("/ort"))
				.andExpect(status().isOk())
				.andExpect(content().json(expectedJson));*/
	}
	
}
