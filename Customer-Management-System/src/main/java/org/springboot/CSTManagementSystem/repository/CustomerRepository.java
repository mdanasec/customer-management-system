package org.springboot.CSTManagementSystem.repository;

import org.springboot.CSTManagementSystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	

}
