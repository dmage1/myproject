package com.example.myapplication.platform;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@Ignore
public class ApplicationPropertiesTest { // Application Properties

    private static final int PROP_SIZE = 26;

    private Properties props = new Properties();

    @Before
    public void setUp() {
        InputStream is = ClassLoader.getSystemResourceAsStream("application.properties");
        try {
            if (is != null) {
                props.load(is);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    public void should_get_appName() {
        assertThat(props.get("app.name"), equalTo("Spring Sample Application"));
    }

    @Test
    public void should_get_appDescription() {
        assertThat(props.get("app.description"), equalTo("${app.name} is a Spring Boot application"));
    }

    @Test
    public void should_get_appVersion() {
        assertThat(props.get("app.version"), equalTo("1.0.0"));
    }
}
