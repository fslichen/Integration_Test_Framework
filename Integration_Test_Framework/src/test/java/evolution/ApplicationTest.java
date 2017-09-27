package evolution;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import evolution.dao.AnyDao;
import evolution.entity.AnyEntity;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)// Used for loading ApplicationContext.
@TestPropertySource("classpath:application.properties")
public class ApplicationTest {
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