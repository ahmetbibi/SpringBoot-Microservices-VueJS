package com.sha.microservicecoursemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MicroserviceCourseManagementApplication {

	// SpringBoot main class is a default configuration class
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCourseManagementApplication.class, args);
	}

	// To allow origins for cross origin resource sharing (CORS) we need a SpringBoot configuration class

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}

}
