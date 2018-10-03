package com.example.myapplication.customer;

import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Repository
public class CustomerRepository {

    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerRepository.class.getName());

    Customer getCustomer(int id) {
        LOGGER.info("getCustomer({})", id);

        Preconditions.checkArgument(id >= 0 && id <= CUSTOMERS.length - 1, "Invalid Customer Id [%s]", id);

        return CUSTOMERS[id];
    }

    List<Customer> getCustomers() {
        LOGGER.info("getCustomers()");
        return Arrays.asList(CUSTOMERS);
    }

    public static Customer[] CUSTOMERS = {
            new Customer(0, "firstName", "lastName", "gender", new Date(), "address","city","state","postCode", "phone", "email", new BigDecimal(0)),
            new Customer(1, "firstName", "lastName", "gender", new Date(), "address","city","state","postCode", "phone", "email", new BigDecimal(0)),
            new Customer(2, "firstName", "lastName", "gender", new Date(), "address","city","state","postCode", "phone", "email", new BigDecimal(0)),
            new Customer(3, "firstName", "lastName", "gender", new Date(), "address","city","state","postCode", "phone", "email", new BigDecimal(0)),
            new Customer(4, "firstName", "lastName", "gender", new Date(), "address","city","state","postCode", "phone", "email", new BigDecimal(0))
    };
}
