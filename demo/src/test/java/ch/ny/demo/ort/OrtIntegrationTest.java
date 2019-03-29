package ch.ny.demo.ort;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import ch.ny.data.DataGenerators;
import ch.ny.data.DataHolder;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@Transactional
public class OrtIntegrationTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private OrtMapper ortMapper;
	
	private DataHolder<Ort> dataHolder;
	
	@Before
	public void setup() {
		// Persist orte
		dataHolder = DataGenerators.forClass(Ort.class).generate();
		dataHolder.asList().stream()
			.peek(a -> a.setId(null))
			.forEach(entityManager::persist);
	}
	
	@Test
	public void test() throws Exception {
		var expectedJson = objectMapper.writeValueAsString(
				ortMapper.toListDTO(dataHolder.asList())
				);
		
		mockMvc.perform(get("/ort"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().json(expectedJson));
	}
	
}
