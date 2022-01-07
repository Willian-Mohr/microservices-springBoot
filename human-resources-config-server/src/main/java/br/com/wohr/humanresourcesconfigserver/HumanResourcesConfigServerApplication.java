package br.com.wohr.humanresourcesconfigserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class HumanResourcesConfigServerApplication implements CommandLineRunner {

	@Value("${spring.cloud.config.server.git.password}")
	private String username;

	public static void main(String[] args) {
		SpringApplication.run(HumanResourcesConfigServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("USERNAME: " + username);

	}

}
