package org.springboot.CSTManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.springboot.CSTManagementSystem.entity.Customer;
import org.springboot.CSTManagementSystem.entity.ResponseStructure;
import org.springboot.CSTManagementSystem.exception.CustomerNotFoundException;
import org.springboot.CSTManagementSystem.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public ResponseEntity<ResponseStructure<Customer>> registerCustomer(Customer customer){
		ResponseStructure<Customer> structure = new ResponseStructure<>();
		structure.setData(customerRepository.save(customer));
		structure.setMessage("Customer Registerd Sucessfully");
		structure.setStatusCode(HttpStatus.CREATED.value());
		
		return new ResponseEntity<ResponseStructure<Customer>>(structure, HttpStatus.CREATED);
	}
	
//	getCustomerById
	public ResponseEntity<ResponseStructure<Customer>> getCustomertById(Integer id){
		ResponseStructure<Customer> structure = new ResponseStructure<>();
		Optional<Customer> recCustomer = customerRepository.findById(id);
		if(recCustomer.isPresent()) {
			structure.setMessage("Customer Found");
			structure.setData(recCustomer.get());
			structure.setStatusCode(HttpStatus.OK.value());
			
			return new ResponseEntity<ResponseStructure<Customer>>(structure, HttpStatus.OK);
		}
		throw new CustomerNotFoundException("Customer Not Found");
	}
	
//	updateCustomer API
	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(Customer customer, Integer id){
		ResponseStructure<Customer> structure = new ResponseStructure<>();
		
		Optional<Customer> recCustomer = customerRepository.findById(id);
		if(recCustomer.isPresent()) {
			Customer existCustomer =  recCustomer.get();
			
			existCustomer.setName(customer.getName());
			existCustomer.setEmail(customer.getEmail());
			existCustomer.setPhone(customer.getPhone());
			existCustomer.setAddress(customer.getAddress());
			
			Customer updateCustomer = customerRepository.save(existCustomer);
			structure.setData(updateCustomer);
			structure.setMessage("Customer Updated Sucessfully");
			structure.setStatusCode(HttpStatus.OK.value());
			
			return new ResponseEntity<ResponseStructure<Customer>>(structure, HttpStatus.OK);
		}
		throw new CustomerNotFoundException("Customer Not Found");	
	}

//	getAllCustomer API
	
	public ResponseEntity<ResponseStructure<List<Customer>>> getAllCustomer(){
		ResponseStructure<List<Customer>> structure= new ResponseStructure<>();
		
		List<Customer> recCustomer =  customerRepository.findAll();
		
		if(recCustomer.size()>0) {
			structure.setMessage("Custome Found");
			structure.setData(recCustomer);
			structure.setStatusCode(HttpStatus.OK.value());
			
			return new ResponseEntity<ResponseStructure<List<Customer>>>(structure, HttpStatus.OK);
		}
		throw new CustomerNotFoundException("Customer Not Found");
	}
	
//	customerDeleteById API
	public ResponseEntity<ResponseStructure<String>> customerDeleteById(Integer id){
		
		Customer recCustomer = customerRepository.findById(id).orElseThrow(()-> new CustomerNotFoundException("Customer not Found"));
		customerRepository.delete(recCustomer);
		
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData("Customer Deleted Sucessfully");
		structure.setMessage("Success");
		structure.setStatusCode(HttpStatus.OK.value());
		
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		

	}
	
}























