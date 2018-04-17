package com.example.demo.repositories;

import com.example.demo.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CheckCustomerRepository extends CrudRepository<Customer, String> {
}
