package org.springboot.CSTManagementSystem.controller;

import java.util.List;
import java.util.Optional;

import org.springboot.CSTManagementSystem.entity.Customer;
import org.springboot.CSTManagementSystem.entity.ResponseStructure;
import org.springboot.CSTManagementSystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@PostMapping(path="/registerCustomer")
	public ResponseEntity<ResponseStructure<Customer>> registerCustomer(@RequestBody Customer customer){
		return customerService.registerCustomer(customer);
	}
	
	@GetMapping(path="/getCustomerById/{id}")
	public ResponseEntity<ResponseStructure<Customer>> getCustomertById(@PathVariable Integer id){
		return customerService.getCustomertById(id);
	}
	
	@PutMapping(path = "/updateCustomer/{id}")
	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(@RequestBody Customer customer, @PathVariable Integer id){
		return customerService.updateCustomer(customer, id);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Customer>>> getAllCustomer(){
		return customerService.getAllCustomer();
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseStructure<String>> customerDeleteById(@PathVariable Integer id){
		return customerService.customerDeleteById(id);
	}
	
	@PostMapping(path="/phone")
	public ResponseEntity<ResponseStructure<Optional<Customer>>> serachByPhone(@RequestParam long phone){
		return customerService.serachByPhone(phone);
	}

}
