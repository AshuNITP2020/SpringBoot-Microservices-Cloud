package com.ak.orderService;

import com.ak.orderService.repository.OrderRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = "com.ak.orderService.repository" +
		"com.ak.orderService.service")
@EntityScan(basePackages = "com.ak.orderService.model")
public class OrderServiceApplication {
	public static void main(String[] args) {
		System.out.println("base");

		SpringApplication.run(OrderServiceApplication.class, args);
	}

}
