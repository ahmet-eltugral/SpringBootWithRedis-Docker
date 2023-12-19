package com.javalaniyoruz.springredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.javalaniyoruz.springredis")
public class SpringRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRedisApplication.class, args);
	}

}
