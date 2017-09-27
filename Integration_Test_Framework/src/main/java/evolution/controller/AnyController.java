package evolution.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
//		AnyDto receivedAnyDto = new RestTemplate().getForObject("http://localhost:8080/get", AnyDto.class); 
		return anyDto;
	}
	
	@GetMapping("/get")
	public AnyDto get() {
		AnyDto anyDto = new AnyDto();
		anyDto.setAge(27);
		anyDto.setGender("M");
		anyDto.setName("Chen");
		return anyDto;
	}
}
