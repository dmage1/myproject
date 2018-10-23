package com.example.myapplication;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ApplicationTest {

    @Test
    public void testVmArgument() {

        // Arrange - set VM argument -Dapp.name="David's Sample Application"
        String key = "app.name";
        String expected = "David's Sample Application";

        // Act
        String actual = System.getProperty(key);

        // Assert
        assertThat(actual, equalTo(expected));
    }
}
