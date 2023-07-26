package com.cfVanguardBackend.oldskoolbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.mongock.runner.springboot.EnableMongock;

@SpringBootApplication
@EnableMongock
public class OldskoolbackendApplication{

	public static void main(String[] args) {
		SpringApplication.run(OldskoolbackendApplication.class, args);
	}

}
