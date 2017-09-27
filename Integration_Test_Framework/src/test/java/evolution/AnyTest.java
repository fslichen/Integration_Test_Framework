package evolution;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;

import evolution.controller.dto.AnyDto;
import evolution.dao.AnyDao;
import evolution.entity.AnyEntity;

public class AnyTest extends BaseTest {
	@Autowired
	private AnyDao anyDao;
	
	@Test
	public void test() throws Exception {
		// Dao Operation
		AnyEntity anyEntity = new AnyEntity();
		anyEntity.setName("Ling");
		anyEntity.setAge(27);
		anyEntity.setGender("F");
		anyDao.insert(anyEntity);
		System.out.println(anyDao.findAll());
		// Configuration
		System.out.println(testConfiguration.getName());
		// MockMvc
		assert mockMvc != null;
		AnyDto anyDto = new AnyDto();
		anyDto.setName("Chen");
		anyDto.setAge(27);
		anyDto.setGender("M");
		ObjectMapper objectMapper = new ObjectMapper();
		mockMvc.perform(post("/post").content(objectMapper.writeValueAsString(anyDto))
				.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andExpect(content().json(objectMapper.writeValueAsString(anyDto), false));
	}
}
