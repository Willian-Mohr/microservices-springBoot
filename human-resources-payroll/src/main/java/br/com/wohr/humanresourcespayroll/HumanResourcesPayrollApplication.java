package br.com.wohr.humanresourcespayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@RibbonClient(name = "human-resources-worker")
public class HumanResourcesPayrollApplication {

	public static void main(String[] args) {
		SpringApplication.run(HumanResourcesPayrollApplication.class, args);
	}

}
