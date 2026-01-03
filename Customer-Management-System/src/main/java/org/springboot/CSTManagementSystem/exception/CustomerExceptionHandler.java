package org.springboot.CSTManagementSystem.exception;


import org.springboot.CSTManagementSystem.entity.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomerExceptionHandler {
	
	public ResponseEntity<ResponseStructure<String>> handleCNFE(CustomerNotFoundException customerNotFoundException){
		ResponseStructure<String> structure = new ResponseStructure<>();
		
		structure.setMessage(customerNotFoundException.getMessage());
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setData("Customer Not Found");
		
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
}
