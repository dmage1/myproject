package com.example.myapplication.customer;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;
import java.util.Date;

public class Customer {

    private int id;

    private String firstName;
    private String lastName;
    private String gender;
    private Date dob;

    private String address;
    private String city;
    private String state;
    private String postCode;

    private String phone;
    private String email;

    private BigDecimal creditLimit;

    Customer(int id, String firstName, String lastName, String gender, Date dob, String address, String city, String state, String postCode, String phone, String email, BigDecimal creditLimit) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.city = city;
        this.state = state;
        this.postCode = postCode;
        this.phone = phone;
        this.email = email;
        this.creditLimit = creditLimit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        return new EqualsBuilder()
                .append(id, customer.id)
                .append(firstName, customer.firstName)
                .append(lastName, customer.lastName)
                .append(gender, customer.gender)
                .append(dob, customer.dob)
                .append(address, customer.address)
                .append(city, customer.city)
                .append(state, customer.state)
                .append(postCode, customer.postCode)
                .append(phone, customer.phone)
                .append(email, customer.email)
                .append(creditLimit, customer.creditLimit)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(firstName)
                .append(lastName)
                .append(gender)
                .append(dob)
                .append(address)
                .append(city)
                .append(state)
                .append(postCode)
                .append(phone)
                .append(email)
                .append(creditLimit)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .append("gender", gender)
                .append("dob", dob)
                .append("address", address)
                .append("city", city)
                .append("state", state)
                .append("postCode", postCode)
                .append("phone", phone)
                .append("email", email)
                .append("creditLimit", creditLimit)
                .toString();
    }
}
