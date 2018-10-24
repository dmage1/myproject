package com.example.myapplication.order;

import com.example.myapplication.customer.Customer;
import com.example.myapplication.product.Product;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Order {

    private int id;

    private Date orderDate;
    private String orderMode;
    private String orderStatus;
    private BigDecimal orderTotal;

    private Customer customer;

    private List<Product> purchasedProducts;

    Order() {
        super();
    }

    Order(int id, Date orderDate, String orderMode, String orderStatus, BigDecimal orderTotal, Customer customer, List<Product> purchasedProducts) {
        this.id = id;
        this.orderDate = orderDate;
        this.orderMode = orderMode;
        this.orderStatus = orderStatus;
        this.orderTotal = orderTotal;
        this.customer = customer;
        this.purchasedProducts = purchasedProducts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderMode() {
        return orderMode;
    }

    public void setOrderMode(String orderMode) {
        this.orderMode = orderMode;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getPurchasedProducts() {
        return purchasedProducts;
    }

    public void setPurchasedProducts(List<Product> purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        return new EqualsBuilder()
                .append(id, order.id)
                .append(orderDate, order.orderDate)
                .append(orderMode, order.orderMode)
                .append(orderStatus, order.orderStatus)
                .append(orderTotal, order.orderTotal)
                .append(customer, order.customer)
                .append(purchasedProducts, order.purchasedProducts)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(orderDate)
                .append(orderMode)
                .append(orderStatus)
                .append(orderTotal)
                .append(customer)
                .append(purchasedProducts)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("orderDate", orderDate)
                .append("orderMode", orderMode)
                .append("orderStatus", orderStatus)
                .append("orderTotal", orderTotal)
                .append("customer", customer)
                .append("purchasedProducts", purchasedProducts)
                .toString();
    }
}
