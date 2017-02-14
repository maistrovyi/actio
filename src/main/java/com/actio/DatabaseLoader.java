package com.actio;

import com.actio.models.b2b.Customer;
import com.actio.repositories.b2b.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DatabaseLoader implements CommandLineRunner {

    @Autowired
    private CustomerRepository repository;

    @Override
    public void run(String... strings) throws Exception {
        this.repository.save(Customer.of()
                .firstName("volodymyr")
                .lastName("maystrovyy")
                .login("maystrovyy")
                .create());
        log.info("Saved 3 customers!");
    }

}