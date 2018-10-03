package com.example.myapplication.customer;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CustomerTest {

    private static final String TEST = "test";

    @Test
    public void testId() {
        Customer customer = new Customer();
        int id = RandomUtils.nextInt(1, 50);
        customer.setId(id);
        assertThat(customer.getId(), is(id));
    }

    @Test
    public void testFirstName() {
        Customer customer = new Customer();
        customer.setFirstName(TEST);
        assertThat(customer.getFirstName(), is(TEST));
    }

    @Test
    public void testLastName() {
        Customer customer = new Customer();
        customer.setLastName(TEST);
        assertThat(customer.getLastName(), is(TEST));
    }

    @Test
    public void testGender() {
        Customer customer = new Customer();
        customer.setGender(TEST);
        assertThat(customer.getGender(), is(TEST));
    }

    @Test
    public void testDob() {
        Customer customer = new Customer();
        Date date = new Date();
        customer.setDob(date);
        assertThat(customer.getDob(), is(date));
    }

    @Test
    public void testAddress() {
        Customer customer = new Customer();
        customer.setAddress(TEST);
        assertThat(customer.getAddress(), is(TEST));
    }

    @Test
    public void testCity() {
        Customer customer = new Customer();
        customer.setCity(TEST);
        assertThat(customer.getCity(), is(TEST));
    }

    @Test
    public void testState() {
        Customer customer = new Customer();
        customer.setState(TEST);
        assertThat(customer.getState(), is(TEST));
    }

    @Test
    public void testPostCode() {
        Customer customer = new Customer();
        customer.setPostCode(TEST);
        assertThat(customer.getPostCode(), is(TEST));
    }

    @Test
    public void testPhone() {
        Customer customer = new Customer();
        customer.setPhone(TEST);
        assertThat(customer.getPhone(), is(TEST));
    }

    @Test
    public void testEmail() {
        Customer customer = new Customer();
        customer.setEmail(TEST);
        assertThat(customer.getEmail(), is(TEST));
    }

    @Test
    public void testCreditLimit() {
        Customer customer = new Customer();
        customer.setCreditLimit(BigDecimal.TEN);
        assertThat(customer.getCreditLimit(), is(BigDecimal.TEN));
    }

}
