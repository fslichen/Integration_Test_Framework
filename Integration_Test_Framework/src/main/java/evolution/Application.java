package evolution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import evolution.dao.AnyDao;
import evolution.entity.AnyEntity;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private AnyDao anyDao;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Override
	public void run(String... arg0) throws Exception {
		AnyEntity anyEntity = new AnyEntity();
		anyEntity.setName("Ling");
		anyDao.insert(anyEntity);
		System.out.println(anyDao.findAll());
	}
}
