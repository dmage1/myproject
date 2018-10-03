package com.example.myapplication.customer;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import org.apache.commons.lang3.RandomUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.example.myapplication.customer.CustomerRepository.CUSTOMERS;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CustomerRepositoryTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private CustomerRepository classToTest;
    @Mock
    private Appender<ILoggingEvent> logAppender;

    @Captor
    private ArgumentCaptor<ILoggingEvent> logEventArgumentCaptor;

    @Before
    public void setUp() {
        ((Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME)).addAppender(logAppender);
        classToTest = new CustomerRepository();
    }

    @After
    public void tearDown() {
        ((Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME)).detachAppender(logAppender);
        classToTest = null;
    }

    @Test
    public void should_returnCustomer_using_customerId() {
        // Arrange
        int id = RandomUtils.nextInt(0, 4);

        // Act
        classToTest.getCustomer(id);

        // Assert
        assertThat(id, equalTo(CUSTOMERS[id].getId()));
    }

    @Test
    public void should_logMessage_when_returnCustomer_using_customerId() {
        // Arrange
        int id = RandomUtils.nextInt(0, 4);

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

        // Act
        List<Customer> actualCustomerList = classToTest.getCustomers();

        // Assert
        assertThat(5, equalTo(actualCustomerList.size()));
    }

    @Test
    public void should_logMessage_when_returnCustomerList() {
        // Arrange

        // Act
        classToTest.getCustomers();

        // Assert
        verify(logAppender, times(1)).doAppend(logEventArgumentCaptor.capture());

        List<ILoggingEvent> loggingEvents = logEventArgumentCaptor.getAllValues();
        assertThat(loggingEvents.get(0).getLevel(), is(Level.INFO));
        assertThat(loggingEvents.get(0).getFormattedMessage(), is("getCustomers()"));
    }

    @Test
    public void should_throwIllegalArgumentException_using_invalidCustomerId() {
        // Arrange
        int invalidId = 5;
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(String.format("Invalid Customer Id [%s]", invalidId));

        // Act
        classToTest.getCustomer(invalidId);

        // Assert
        verify(logAppender, times(1)).doAppend(logEventArgumentCaptor.capture());

        List<ILoggingEvent> loggingEvents = logEventArgumentCaptor.getAllValues();
        assertThat(loggingEvents.get(0).getLevel(), is(Level.INFO));
        assertThat(loggingEvents.get(0).getFormattedMessage(), is(String.format("getCustomer(%s)", invalidId)));
    }

}
