package com.altice.alticci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AlticciApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlticciApplication.class, args);
	}

}
