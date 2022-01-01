package br.com.wohr.humanresourcespayroll.services;

import org.springframework.stereotype.Service;

import br.com.wohr.humanresourcespayroll.entities.Payment;

@Service
public class PaymentService {
	
	public Payment getPayment(long workerId, int days) {
		
		return new Payment("Bob", 200.0, days);
		
	}

}
