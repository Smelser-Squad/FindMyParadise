package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.exceptions.InvalidHostIDException;
import com.tp.wrc.findmyparadise.exceptions.NullHostIDException;
import com.tp.wrc.findmyparadise.models.Event;
import com.tp.wrc.findmyparadise.models.Host;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HostServiceImplTests {

    HostServiceImpl service;

    @BeforeEach
    public void setup() throws NullHostIDException, InvalidHostIDException {
        Host test = new Host();
        test.setEmail("test@email.com");
        test.setHostName("test name");
        test.setImageSrc("test img src");
        test.setSuperHost(true);
        test.setJoinDate("May 2020");
        test.setResponseRate(100.00);
        test.setResponseTime("test response time");
        test.setTotalReviews("test total reviews");
        test.setVerified(true);

        service.create(test);
    }

    @Test //Testing retrieving an event by ID.
    public void findEventByIdTest() throws NullHostIDException, InvalidHostIDException {
        Host test = service.show(1);
        assertEquals("test@email.com", test.getEmail());

    }


}