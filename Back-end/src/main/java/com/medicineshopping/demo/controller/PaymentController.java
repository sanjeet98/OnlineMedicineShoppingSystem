package com.medicineshopping.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicineshopping.demo.constant.PaymentConstant;
import com.medicineshopping.demo.dao.PaymentRepo;
import com.medicineshopping.demo.dto.PaymentDTO;
import com.medicineshopping.demo.dto.SuccessMessageDTO;
import com.medicineshopping.demo.entity.Payment;
import com.medicineshopping.demo.exceptions.CartException;
import com.medicineshopping.demo.exceptions.PaymentException;
import com.medicineshopping.demo.exceptions.UserNotFoundException;
import com.medicineshopping.demo.exceptions.ValidateException;
import com.medicineshopping.demo.service.PaymentSer;

/**
 * @author Kaul's
 *
 */
@SuppressWarnings("unused")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class PaymentController {

	@Autowired
	private PaymentRepo paymentRepo;
	@Autowired
	PaymentSer paymentser;

	@GetMapping("/payments")
	public List<Payment> getAllPayments() {
		return paymentRepo.findAll();
	}

	@PostMapping("/addpayment")
	public SuccessMessageDTO addpayment(@Valid @RequestBody PaymentDTO paymentdto, BindingResult br)
			throws ValidateException, CartException, UserNotFoundException {
		if (br.hasErrors()) // checks invalid field entry
			throw new ValidateException(br.getFieldErrors()); // throws the error

		Payment item = paymentser.addPayment(paymentdto);
		return new SuccessMessageDTO(PaymentConstant.PAYMENT_DONE + item.getPaymentId()); // if all entries are correct,
																							// User gets a success
																							// message with the payment
																							// ID
	}

	@PostMapping("/payments")
	public Payment createPayment(@RequestBody Payment payment) {
		return paymentRepo.save(payment);
	}

	@GetMapping("/payments/{id}")
	public Optional<Payment> getPaymentById(@PathVariable("id") int id) {
		Optional<Payment> payment = paymentRepo.findById(id);
		return (payment);
	}

	@PutMapping("/payments/{id}")
	public Payment updatePayment(@PathVariable int id, @RequestBody Payment paymentDetails) {
		Payment payment = paymentRepo.save(paymentDetails);
		paymentRepo.deleteById(id);
		return payment;
	}

	@DeleteMapping("/payments/{id}")
	public void deletePayment(@PathVariable int id) {
		paymentRepo.deleteById(id);
	}

}