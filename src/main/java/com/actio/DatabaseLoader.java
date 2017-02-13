package com.actio;

import com.actio.models.b2b.Employee;
import com.actio.repositories.b2b.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DatabaseLoader implements CommandLineRunner {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public void run(String... strings) throws Exception {
        this.repository.save(Employee.of()
                .firstName("volodymyr")
                .lastName("maystrovyy")
                .login("maystrovyy")
                .create());
        log.info("Saved 3 employees!");
    }

}