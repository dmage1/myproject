package com.example.myapplication.customer;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import org.apache.commons.lang3.RandomUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @Mock
    CustomerRepository repository;
    @Mock
    Customer mockCustomer;
    @Mock
    List<Customer> mockCustomerList;
    private CustomerService classToTest;
    @Mock
    private Appender<ILoggingEvent> logAppender;

    @Captor
    private ArgumentCaptor<ILoggingEvent> logEventArgumentCaptor;

    @Before
    public void setUp() {
        ((Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME)).addAppender(logAppender);
        classToTest = new CustomerService(repository);
    }

    @After
    public void tearDown() {
        ((Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME)).detachAppender(logAppender);
        classToTest = null;
    }

    @Test
    public void should_returnCustomer_using_customerId() {
        // Arrange
        int id = RandomUtils.nextInt(1, 50);
        when(mockCustomer.getId()).thenReturn(id);
        when(repository.getCustomer(id)).thenReturn(mockCustomer);

        // Act
        Customer actualCustomer = classToTest.getCustomer(id);

        // Assert
        assertThat(id, equalTo(actualCustomer.getId()));
    }

    @Test
    public void should_logMessage_when_returnCustomer_using_customerId() {
        // Arrange
        int id = RandomUtils.nextInt(1, 50);
        when(mockCustomer.getId()).thenReturn(id);
        when(repository.getCustomer(id)).thenReturn(mockCustomer);

        // Act
        classToTest.getCustomer(id);

        // Assert
        verify(logAppender, times(1)).doAppend(logEventArgumentCaptor.capture());

        List<ILoggingEvent> loggingEvents = logEventArgumentCaptor.getAllValues();
        assertThat(loggingEvents.get(0).getLevel(), is(Level.INFO));
        assertThat(loggingEvents.get(0).getFormattedMessage(), is(String.format("getCustomer(%s)", id)));
    }

    @Test
    public void should_returnCustomerList() {
        // Arrange
        when(repository.getCustomers()).thenReturn(mockCustomerList);

        // Act
        List<Customer> actualCustomerList = classToTest.getCustomers();

        // Assert
        assertThat(mockCustomerList.size(), equalTo(actualCustomerList.size()));
    }

    @Test
    public void should_logMessage_when_returnCustomerList() {
        // Arrange
        int id = RandomUtils.nextInt(1, 50);
        when(mockCustomer.getId()).thenReturn(id);
        when(repository.getCustomer(id)).thenReturn(mockCustomer);

        // Act
        classToTest.getCustomers();

        // Assert
        verify(logAppender, times(1)).doAppend(logEventArgumentCaptor.capture());

        List<ILoggingEvent> loggingEvents = logEventArgumentCaptor.getAllValues();
        assertThat(loggingEvents.get(0).getLevel(), is(Level.INFO));
        assertThat(loggingEvents.get(0).getFormattedMessage(), is("getCustomers()"));
    }
}
