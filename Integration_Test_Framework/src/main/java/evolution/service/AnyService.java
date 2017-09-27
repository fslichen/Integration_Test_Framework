package evolution.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import evolution.controller.dto.AnyDto;
import evolution.dao.AnyDao;
import evolution.entity.AnyEntity;

@Service
public class AnyService {
	@Autowired
	private AnyDao anyDao;
	
	public List<AnyEntity> anyMethod() {
		List<AnyEntity> anyEntities = anyDao.findAll();
		System.out.println(String.format("AnyService : anyMethod() executes successfully, anyEntities = %s.", anyEntities));
		return anyEntities;
	}
	
	public AnyDto anotherMethod(String url) {
		return new RestTemplate().getForObject(url, AnyDto.class);
	}
}
