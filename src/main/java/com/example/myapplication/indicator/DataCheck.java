package com.example.myapplication.indicator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class DataCheck implements HealthIndicator {

    private final static Logger LOGGER = LoggerFactory.getLogger(DataCheck.class.getName());

    @Override
    public Health health() {

        LOGGER.info("DataCheck()");

        int errorCode = check(); // perform some specific health check
        if (errorCode != 0) {
            return Health.down().withDetail("Error Code", errorCode).build();
        }
        return Health.up().build();
    }

    private int check() {
        // Our logic to check health
        return 0;
    }

}
