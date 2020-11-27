package com.sud.zuul.resource;

import java.security.Principal;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class GreetResource {
	@GetMapping
	public String sayHello() {
		return "Hello";
	}
	@GetMapping("/greet")
	public String greet(Principal p) {
		return p.toString();
	}
}
