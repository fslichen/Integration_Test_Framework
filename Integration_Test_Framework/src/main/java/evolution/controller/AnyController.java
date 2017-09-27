package evolution.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import evolution.controller.dto.AnyDto;
import evolution.entity.AnyEntity;
import evolution.service.AnyService;

@RestController
public class AnyController {
	@Autowired
	private AnyService anyService;
	
	@PostMapping("/post")
	public AnyDto post(@RequestBody AnyDto anyDto) {
		List<AnyEntity> anyEntities = anyService.anyMethod();
		System.out.println(anyEntities);
		return anyDto;
	}
}
