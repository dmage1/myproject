package com.example.myapplication.product;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

public class Product {

    private int id;

    private String name;
    private String description;
    private String category;
    private String status;

    private BigDecimal listPrice;
    private BigDecimal minPrice;

    Product() {
        super();
    }

    Product(int id, String name, String description, String category, String status, BigDecimal listPrice, BigDecimal minPrice) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.status = status;
        this.listPrice = listPrice;
        this.minPrice = minPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getListPrice() {
        return listPrice;
    }

    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        return new EqualsBuilder()
                .append(id, product.id)
                .append(name, product.name)
                .append(description, product.description)
                .append(category, product.category)
                .append(status, product.status)
                .append(listPrice, product.listPrice)
                .append(minPrice, product.minPrice)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(name)
                .append(description)
                .append(category)
                .append(status)
                .append(listPrice)
                .append(minPrice)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("description", description)
                .append("category", category)
                .append("status", status)
                .append("listPrice", listPrice)
                .append("minPrice", minPrice)
                .toString();
    }
}

