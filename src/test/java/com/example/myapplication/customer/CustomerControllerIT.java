package com.example.myapplication.customer;

import com.jayway.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

public class CustomerControllerIT {

    @Test
    public void shouldReturn_customer() {

        given().
                pathParam("id", "1").
                when().
                get("http://localhost:8080/customers/{id}/").
                then().
                statusCode(HttpStatus.SC_OK). // 200
                body("id", equalTo(1)).
                body("firstName", equalTo("firstName")).
                body("lastName", equalTo("lastName")).
                body("gender", equalTo("gender")).
                body("dob", is(notNullValue())).
                body("address", equalTo("address")).
                body("city", equalTo("city")).
                body("state", equalTo("state")).
                body("postCode", equalTo("postCode")).
                body("phone", equalTo("phone")).
                body("email", equalTo("email")).
                body("creditLimit", equalTo(0));
    }

    @Test
    public void shouldReturn_customerList() {

        given().
                when().
                get("http://localhost:8080/customers/").
                then().
                statusCode(HttpStatus.SC_OK).
                contentType(ContentType.JSON).
                body("results.size()", equalTo(5));
    }
}
