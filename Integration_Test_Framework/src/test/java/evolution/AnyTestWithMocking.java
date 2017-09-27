package evolution;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import evolution.controller.dto.AnotherDto;
import evolution.controller.dto.AnyDto;
import evolution.service.AnyService;

public class AnyTestWithMocking extends BaseTest {
	@MockBean
	private AnyService anyService;
	
	@Test
	public void testMvc() throws JsonProcessingException, Exception {
		AnyDto anyDto = new AnyDto();
		anyDto.setName("Chen");
		when(anyService.anotherMethod("www.google.com")).thenReturn(anyDto);
		AnotherDto anotherDto = new AnotherDto();
		anotherDto.setUrl("www.google.com");
		ObjectMapper objectMapper = new ObjectMapper();
		mockMvc.perform(post("/mock").content(objectMapper.writeValueAsString(anotherDto))
				.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andExpect(content().json(objectMapper.writeValueAsString(anyDto)));
	}
}
