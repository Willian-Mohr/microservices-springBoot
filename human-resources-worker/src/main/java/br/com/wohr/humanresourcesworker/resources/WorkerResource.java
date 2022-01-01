package br.com.wohr.humanresourcesworker.resources;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.wohr.humanresourcesworker.entities.Worker;
import br.com.wohr.humanresourcesworker.repositories.WorkerRepository;

@Controller
@RequestMapping(value = "/workers")
public class WorkerResource {

	@Autowired
	private WorkerRepository repository;
	
	@Autowired
	private Environment environment;
	
	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {

		List<Worker> list = repository.findAll();

		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) throws Exception {
		
		logger.info("PORT = " + environment.getProperty("local.server.port"));

		Optional<Worker> worker = repository.findById(id);

		return ResponseEntity.ok(worker.orElseThrow(() -> new Exception("Não localizado: ID " + id)));
	}

}
