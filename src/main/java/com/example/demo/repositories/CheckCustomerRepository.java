package com.example.demo.repositories;

import com.example.demo.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CheckCustomerRepository extends JpaRepository<Customer, String> {
}
