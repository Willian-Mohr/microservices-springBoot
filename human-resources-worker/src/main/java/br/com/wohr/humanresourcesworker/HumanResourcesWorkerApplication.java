package br.com.wohr.humanresourcesworker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HumanResourcesWorkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HumanResourcesWorkerApplication.class, args);
	}

}
