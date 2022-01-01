package br.com.wohr.humanresourcesworker.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.wohr.humanresourcesworker.entities.Worker;
import br.com.wohr.humanresourcesworker.repositories.WorkerRepository;

@Controller
@RequestMapping(value = "/workers")
public class workerResource {

	@Autowired
	private WorkerRepository repository;

	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {

		List<Worker> list = repository.findAll();

		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) throws Exception {

		Optional<Worker> worker = repository.findById(id);

		return ResponseEntity.ok(worker.orElseThrow(() -> new Exception("Não localizado: ID " + id)));
	}

}
