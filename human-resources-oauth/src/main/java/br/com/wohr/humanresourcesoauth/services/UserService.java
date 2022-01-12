package br.com.wohr.humanresourcesoauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.wohr.humanresourcesoauth.entities.User;
import br.com.wohr.humanresourcesoauth.feignclients.UserFeignClient;

@Service
public class UserService implements UserDetailsService {

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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userFeignClient.findByIdEmail(username).getBody();

		if (user == null) {

			throw new UsernameNotFoundException("Email not found");

		}
		
		return user;
	}

}
