package evolution;

import javax.annotation.PostConstruct;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)// Classes is used for loading ApplicationContext.
@TestPropertySource("classpath:application.properties")
public class BaseTest {
	@Autowired
	protected TestConfiguration testConfiguration;
	
	@Autowired
	protected WebApplicationContext webApplicationContext;
	
	protected MockMvc mockMvc;
	
	@PostConstruct// Used on a method that needs to be executed after dependency injection.
	public void postConstruct() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
}