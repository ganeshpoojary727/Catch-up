package com.catchup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CatchupApplication {
	public static void main(String[] args) {
		SpringApplication.run(CatchupApplication.class, args);
	}

	@RequestMapping("/")


	public String sayHello() {
		return "hello world";
	}

}