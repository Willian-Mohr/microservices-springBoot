package br.com.wohr.humanresourcespayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wohr.humanresourcespayroll.entities.Payment;
import br.com.wohr.humanresourcespayroll.entities.Worker;
import br.com.wohr.humanresourcespayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {

	@Autowired
	private WorkerFeignClient workerFeignClient;

	public Payment getPayment(long workerId, int days) {

		Worker worker = workerFeignClient.findById(workerId).getBody();

		return new Payment(worker.getName(), worker.getDailyIncome(), days);

	}

}
