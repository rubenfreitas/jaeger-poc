package com.rfreitas.jaegerpoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCaching(proxyTargetClass = true)
public class JaegerPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(JaegerPocApplication.class, args);
	}

}
