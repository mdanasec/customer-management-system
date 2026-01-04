package org.springboot.CSTManagementSystem.repository;

import java.util.Optional;

import org.springboot.CSTManagementSystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	@Query("SELECT c From Customer c Where c.phone=?1")
	Optional<Customer> searchByPhone(long phone);
	

}
