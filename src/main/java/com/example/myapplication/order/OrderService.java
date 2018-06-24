package com.example.myapplication.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final static Logger LOGGER = LoggerFactory.getLogger(OrderService.class.getName());

    @Autowired
    private OrderRepository repository;

    Order getOrder(int id) {
        LOGGER.info("getOrder({})", id);
        return repository.getOrder(id); }

    List<Order> getOrders() {
        LOGGER.info("getOrders()");
        return repository.getOrders();
    }
}
