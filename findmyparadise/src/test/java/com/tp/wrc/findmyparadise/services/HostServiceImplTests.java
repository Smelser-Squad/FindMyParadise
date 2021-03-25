package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.exceptions.InvalidHostIDException;
import com.tp.wrc.findmyparadise.exceptions.NullHostIDException;
import com.tp.wrc.findmyparadise.models.Event;
import com.tp.wrc.findmyparadise.models.Host;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class HostServiceImplTests {

    @Autowired
    HostServiceImpl service;

    @BeforeEach
    public void setup() throws NullHostIDException, InvalidHostIDException {
        Host test = new Host();
        test.setHostName("test name");
        test.setSuperHost(true);
        test.setVerified(true);
        test.setResponseTime("test response time");
        test.setResponseRate(100.00);
        test.setJoinDate("May 2020");
        test.setEmail("test@email.com");
        test.setImageSrc("test img src");
        test.setTotalReviews("test total reviews");


        service.create(test);
    }

    @Test //Testing retrieving an event by ID.
    public void findEventByIdTest() throws NullHostIDException, InvalidHostIDException {
        Host test = service.show(1);
        assertEquals("test name", test.getHostName());

        assertEquals("test@email.com", test.getEmail());

    }


}
