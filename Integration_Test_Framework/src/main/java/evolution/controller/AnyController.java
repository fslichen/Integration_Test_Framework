package evolution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import evolution.controller.dto.AnotherDto;
import evolution.controller.dto.AnyDto;
import evolution.service.AnyService;

@RestController
public class AnyController {
	@Autowired
	private AnyService anyService;
	
	@PostMapping("/post")
	public AnyDto post(@RequestBody AnyDto anyDto) {
		anyService.anyMethod();
		return anyDto;
	}
	
	@PostMapping("/mock")
	public AnyDto mock(@RequestBody AnotherDto anotherDto) {
		return anyService.anotherMethod(anotherDto.getUrl());
	}
}
