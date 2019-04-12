package com.rfreitas.jaegerpoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching(proxyTargetClass = true)
public class JaegerPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(JaegerPocApplication.class, args);
	}

}
