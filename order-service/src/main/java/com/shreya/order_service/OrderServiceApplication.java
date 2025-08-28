package com.shreya.order_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {
		"com.shreya.base_domains",
		"com.shreya.order_service"
})
@EnableMongoRepositories(basePackages = {
		"com.shreya.base_domains.repository",
		"com.shreya.order_service.repository"
})
@EntityScan(basePackages = {
		"com.shreya.base_domains.entity",
		"com.shreya.order_service.entity"

})
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

}
