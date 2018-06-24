package com.example.myapplication.order;

import com.example.myapplication.customer.CustomerController;
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
@RequestMapping(value="/orders")
public class OrderController {

    private final static Logger LOGGER = LoggerFactory.getLogger(OrderController.class.getName());

    @Autowired
    private OrderService service;

    @RequestMapping(value="/{id}", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public Order getOrder(@PathVariable int id) {
        LOGGER.info("getOrder({})", id);
        return service.getOrder(id);
    }

    @RequestMapping(value="/", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Order> getOrders() { return service.getOrders(); }
}
