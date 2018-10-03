package com.example.myapplication.customer;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        CustomerTest.class,
        CustomerServiceTest.class,
        CustomerRepositoryTest.class
})

public class AllCustomerTests {
}
