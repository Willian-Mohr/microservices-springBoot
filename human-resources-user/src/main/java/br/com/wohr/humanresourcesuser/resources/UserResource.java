package br.com.wohr.humanresourcesuser.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.wohr.humanresourcesuser.entities.User;
import br.com.wohr.humanresourcesuser.repositories.UserRepository;

@Controller
@RequestMapping(value = "/users")
@RefreshScope
public class UserResource {

	@Autowired
	private UserRepository repository;

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) throws Exception {

		Optional<User> user = repository.findById(id);

		return ResponseEntity.ok(user.orElseThrow(() -> new Exception("Não localizado: ID " + id)));

	}

	@GetMapping(value = "/search")
	public ResponseEntity<User> findByIdEmail(@RequestParam String email) throws Exception {

		Optional<User> user = repository.findByEmail(email);

		return ResponseEntity.ok(user.orElseThrow(() -> new Exception("Não localizado: Email " + email)));

	}
}
