package br.com.wohr.humanresourcesoauth.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.wohr.humanresourcesoauth.entities.User;

@Component
@FeignClient(name = "human-resources-user", path = "/users")
public interface UserFeignClient {

	@GetMapping(value = "/search")
	ResponseEntity<User> findByIdEmail(@RequestParam String email);
}
