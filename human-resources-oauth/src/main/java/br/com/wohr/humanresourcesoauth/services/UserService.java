package br.com.wohr.humanresourcesoauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wohr.humanresourcesoauth.entities.User;
import br.com.wohr.humanresourcesoauth.feignclients.UserFeignClient;

@Service
public class UserService {

	@Autowired
	private UserFeignClient userFeignClient;

	public User findByEmail(String email) {

		Logger logger = LoggerFactory.getLogger(UserService.class);

		User user = userFeignClient.findByIdEmail(email).getBody();

		if (user.getEmail() == null) {

			logger.info("Email not found: " + email);
			throw new IllegalArgumentException("Email not found");

		}

		logger.info("Email found: " + email);
		return user;

	}

}
