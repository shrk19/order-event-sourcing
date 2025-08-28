package com.shreya.shipping_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {
		"com.shreya.shipping_service",
		"com.shreya.base_domains"
})
@EnableMongoRepositories(basePackages = "com.shreya.base_domains.repository")
@EntityScan(basePackages = "com.shreya.base_domains.entity")
public class ShippingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShippingServiceApplication.class, args);
	}

}
