package com.richard;

import com.richard.domain.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;


@EnableCaching
@SpringBootApplication
public class AppCacheApplication {

	@Autowired
	private ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(AppCacheApplication.class, args);
	}


	@Bean
	ApplicationRunner runner() {
		return args -> {
			System.out.println("========================================");
			System.out.println("Id: 1: " + productService.getById(1L));
			System.out.println("Id: 2: " + productService.getById(2L));
			System.out.println("Id: 1: " + productService.getById(1L));
			System.out.println("Id: 1: " + productService.getById(1L));
			System.out.println("Id: 1: " + productService.getById(1L));
		};
	}

}
