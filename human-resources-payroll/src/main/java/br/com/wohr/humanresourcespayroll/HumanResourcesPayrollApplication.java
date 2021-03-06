package br.com.wohr.humanresourcespayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@EnableCircuitBreaker
public class HumanResourcesPayrollApplication {

	public static void main(String[] args) {
		SpringApplication.run(HumanResourcesPayrollApplication.class, args);
	}

}
