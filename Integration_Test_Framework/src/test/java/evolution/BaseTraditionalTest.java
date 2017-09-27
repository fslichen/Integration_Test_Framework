package evolution;

import javax.annotation.PostConstruct;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)// Used to determine how to load and configure ApplicationContext for integration tests.
// Used to declare that ApplicationContext loaded for an integration test should be a WebApplicationContext.
// Must be used in conjunction with @ContextConfiguration.
@WebAppConfiguration
@TestPropertySource("classpath:application.properties")
public class BaseTraditionalTest {
	@Autowired
	protected WebApplicationContext webApplicationContext;
	
	@Autowired
	protected TestConfiguration testConfiguration;
	
	protected MockMvc mockMvc;
	
	@PostConstruct
	public void postConstruct() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
}
