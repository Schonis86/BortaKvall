package com.example.demo.repositories;

import com.example.demo.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface RentalInterfaceController extends CrudRepository<Customer, String> {

}
