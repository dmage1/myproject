package com.example.myapplication.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/customers")
public class CustomerController {

    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerController.class.getName());

    @Autowired
    private CustomerService service;

    // http://localhost:8080/customers/1
    @RequestMapping(value="/{id}", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public Customer getCustomer(@PathVariable int id) {
        LOGGER.info("getCustomer({})", id);
        return service.getCustomer(id);
    }

    // http://localhost:8080/customers/
    @RequestMapping(value="/", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> getCustomers() {
        LOGGER.info("getCustomers()");
        return service.getCustomers(); }
}
