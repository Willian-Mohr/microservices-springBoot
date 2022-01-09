package br.com.wohr.humanresourcesuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HumanResourcesUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(HumanResourcesUserApplication.class, args);
	}

}
