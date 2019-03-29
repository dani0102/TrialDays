package ch.ny.demo.berufsbildner;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = BerufsbildnerController.class, includeFilters = {
		@Filter(classes = {BerufsbildnerMapper.class},
				type = FilterType.ASSIGNABLE_TYPE)
})
public class BerufsbildnerControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private BerufsbildnerService berufsbildnerService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private BerufsbildnerMapper berufsbildnerMapper;
	
	private DataHolder<Berufsbildner> dataHolder;
	
	@Before
	public void setup() {
		this.dataHolder = DataGenerators.forClass(Berufsbildner.class).generate();
	}
	
	@Test
	public void test() throws Exception {
		when(berufsbildnerService.getAll()).thenReturn(dataHolder.asList());
		
		var expectedJson = objectMapper.writeValueAsString(
				berufsbildnerMapper.toListDTO(dataHolder.asList())
		);		
		
		mockMvc.perform(get("/berufsbildner"))
				.andExpect(status().isOk())
				.andExpect(content().json(expectedJson));
	}
	
}
