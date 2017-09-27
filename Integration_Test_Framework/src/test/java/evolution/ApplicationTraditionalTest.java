package evolution;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import evolution.dao.AnyDao;
import evolution.entity.AnyEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@WebAppConfiguration
@TestPropertySource("classpath:application.properties")
public class ApplicationTraditionalTest {
	@Autowired
	private AnyDao anyDao;
	
	@Test
	public void test() {
		AnyEntity anyEntity = new AnyEntity();
		anyEntity.setName("Ling");
		anyDao.insert(anyEntity);
		System.out.println(anyDao.findAll());
	}
}
