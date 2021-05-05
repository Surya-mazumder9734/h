package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.AuthorDao;
import com.example.demo.model.Author;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
@EnableSwagger2

public class AuthorServiceApplication implements CommandLineRunner{
private AuthorDao authorDao;
	
	
	public AuthorServiceApplication(AuthorDao authorDao) {
		super();
		this.authorDao = authorDao;
	}
	public static void main(String[] args) {
		SpringApplication.run(AuthorServiceApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		authorDao.saveAndFlush(new Author(1,"J.K.Rowling"));
		authorDao.saveAndFlush(new Author(2,"SaratChadra"));
		authorDao.saveAndFlush(new Author(3,"auth-3"));
		authorDao.saveAndFlush(new Author(4,"auth-4"));
	}

	@Bean
	   public Docket productApi() {
	      return new Docket(DocumentationType.SWAGGER_2).select()
	         .apis(RequestHandlerSelectors.basePackage("com.example.demo")).build();
	   }

}
