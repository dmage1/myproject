package com.example.myapplication.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class CustomerService {

    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerService.class.getName());

    private CustomerRepository repository;

    @Autowired
    CustomerService(CustomerRepository repository) {
        super();
        this.repository = repository;
    }

    Customer getCustomer(int id) {
        LOGGER.info("getCustomer({})", id);
        return repository.getCustomer(id);
    }

    List<Customer> getCustomers() {
        LOGGER.info("getCustomers()");
        return repository.getCustomers();
    }
}
