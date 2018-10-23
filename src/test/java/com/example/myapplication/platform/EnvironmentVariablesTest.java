package com.example.myapplication.platform;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Properties;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class EnvironmentVariablesTest { // Computer Environment Properties

    private static final int PROP_SIZE = 74;

    private Properties props = new Properties();

    @Before
    public void setUp() {
        props.putAll(System.getenv());
    }

    @After
    public void tearDown() {
        props.clear();
    }

    @Test
    public void should_printAll() {
        props.entrySet().forEach(System.out::println);
    }

    @Test
    public void should_get_size() {
        assertThat(props.size(), equalTo(PROP_SIZE));
    }

    @Test
    public void should_getProperty_computerName() {
        assertThat(System.getProperty("COMPUTERNAME"), equalTo("HOME-PC"));
    }
}
