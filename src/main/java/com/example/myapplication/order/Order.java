package com.example.myapplication.order;

import com.example.myapplication.customer.Customer;
import com.example.myapplication.product.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
class Order {

    @NotNull
    private int id;

    private Date orderDate;
    private String orderMode;
    private String orderStatus;
    private BigDecimal orderTotal;

    private Customer customer;

    private List<Product> purchasedProducts;

}
