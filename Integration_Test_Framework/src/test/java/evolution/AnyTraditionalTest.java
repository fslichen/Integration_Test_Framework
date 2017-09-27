package evolution;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import evolution.dao.AnyDao;
import evolution.entity.AnyEntity;

public class AnyTraditionalTest extends BaseTraditionalTest {
	@Autowired
	private AnyDao anyDao;
	
	@Test
	public void test() {
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
	}
}
