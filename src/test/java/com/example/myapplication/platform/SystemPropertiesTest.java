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
public class SystemPropertiesTest { // Java System Properties

    private static final int PROP_SIZE = 56;

    private Properties props = new Properties();

    @Before
    public void setUp() {
        props.putAll(System.getProperties());
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
    public void should_getProperty_fileEncoding() {
        assertThat(System.getProperty("file.encoding"), equalTo("UTF-8"));
    }

    @Test
    public void should_getProperty_appDescription() {
        // Arrange
        Properties appProps = loadProperties();

        // Act, by setting the system properties
        System.setProperties(appProps);

        // Assert
        assertThat(System.getProperty("app.name"), equalTo("Spring Sample Application"));
    }

    private Properties loadProperties() {
        Properties properties = new Properties();
        InputStream is = ClassLoader.getSystemResourceAsStream("application.properties");
        try {
            if (is != null) {
                properties.load(is);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
