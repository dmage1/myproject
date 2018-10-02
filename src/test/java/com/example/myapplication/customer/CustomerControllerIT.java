package com.example.myapplication.customer;

import com.jayway.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class CustomerControllerIT {

    @Test
    public void getCustomerTest() {

        given().
                pathParam("id", "1").
                when().
                get("http://localhost:8080/customers/{id}/").
                then().
                statusCode(HttpStatus.SC_OK). // 200
                contentType(ContentType.JSON);
    }

    @Test
    public void getCustomers() {

        given().
                when().
                get("http://localhost:8080/customers/").
                then().
                statusCode(HttpStatus.SC_OK).
                contentType(ContentType.JSON);
    }
}
