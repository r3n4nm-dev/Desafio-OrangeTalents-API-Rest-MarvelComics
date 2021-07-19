package com.renanmateus.comic;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiRestComicApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestComicApplication.class, args);
	
	}

}
