package evolution.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import evolution.dao.AnyDao;
import evolution.entity.AnyEntity;

@Service
public class AnyService {
	@Autowired
	private AnyDao anyDao;
	
	public List<AnyEntity> anyMethod() {
		List<AnyEntity> anyEntities = anyDao.findAll();
		return anyEntities;
	}
}
