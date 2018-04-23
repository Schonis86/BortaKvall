package com.example.demo.repositories;

import com.example.demo.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer, String> {

    List<Customer> findBySocialNumber(String socialNumber);
    List<Customer> findAllByLNameContainingIgnoreCase(String lName);
}
