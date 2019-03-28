package ch.ny.demo.schnuppertag;

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
import ch.ny.schnuppertag.Schnuppertag;
import ch.ny.schnuppertag.SchnuppertagController;
import ch.ny.schnuppertag.SchnuppertagMapper;
import ch.ny.schnuppertag.SchnuppertagService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = SchnuppertagController.class, includeFilters = {
		@Filter(classes = {SchnuppertagMapper.class},
				type = FilterType.ASSIGNABLE_TYPE)
})
public class SchnuppertagControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private SchnuppertagService schnuppertagService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private SchnuppertagMapper schnuppertagMapper;
	
	private DataHolder<Schnuppertag> dataHolder;
	
	@Before
	public void setup() {
		this.dataHolder = DataGenerators.forClass(Schnuppertag.class).generate();
	}
	
	@Test
	public void test() throws Exception {
		when(schnuppertagService.getAll()).thenReturn(dataHolder.asList());
		
		var expectedJson = objectMapper.writeValueAsString(
				schnuppertagMapper.toListDTO(dataHolder.asList())
		);
		
		
		
		mockMvc.perform(get("/schnuppertag"))
				.andExpect(status().isOk())
				.andExpect(content().json(expectedJson));
	}
	
}
