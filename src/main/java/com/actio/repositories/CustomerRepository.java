package com.actio.repositories;

import com.actio.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
