package evolution;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;

import evolution.controller.dto.AnyDto;
import evolution.dao.AnyDao;
import evolution.entity.AnyEntity;

public class AnyTestWithoutMocking extends BaseTest {
	@Autowired
	private AnyDao anyDao;
	
	@Test
	public void testDao() {
		AnyEntity anyEntity = new AnyEntity();
		anyEntity.setName("Ling");
		anyEntity.setAge(27);
		anyEntity.setGender("F");
		anyDao.insert(anyEntity);
		System.out.println(String.format("Dao operation is successful, anyEntities = %s.", anyDao.findAll()));
	}
	
	@Test
	public void testConfiguration() {
		System.out.println(String.format("Successfully fetched the configuration %s.", testConfiguration.getName()));
	}
	
	@Test
	public void testMvc() throws Exception {
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
