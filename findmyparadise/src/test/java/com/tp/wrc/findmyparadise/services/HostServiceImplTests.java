package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.exceptions.InvalidHostEmailException;
import com.tp.wrc.findmyparadise.exceptions.InvalidHostIDException;
import com.tp.wrc.findmyparadise.exceptions.InvalidHostNameException;
import com.tp.wrc.findmyparadise.exceptions.NullHostIDException;
import com.tp.wrc.findmyparadise.models.Event;
import com.tp.wrc.findmyparadise.models.Host;
import com.tp.wrc.findmyparadise.services.HostServiceImpl;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class HostServiceImplTests {

    @Autowired
    HostServiceImpl service;

    @Test
    public void createHostInvalidEmail(){
        Host test = new Host();
        test.setHostName("test name");
        test.setSuperHost(true);
        test.setVerified(true);
        test.setResponseTime("test response time");
        test.setResponseRate(100.00);
        test.setJoinDate("May 2020");
        test.setEmail("testemail.com");
        test.setImageSrc("test img src");
        test.setTotalReviews("test total reviews");
        try {
            service.create(test);
            fail();
        } catch (NullHostIDException | InvalidHostNameException | InvalidHostIDException e) {
            fail();
        } catch (InvalidHostEmailException e) {

        }
        Host test2 = new Host();
        test2.setHostName("test name");
        test2.setSuperHost(true);
        test2.setVerified(true);
        test2.setResponseTime("test response time");
        test2.setResponseRate(100.00);
        test2.setJoinDate("May 2020");
        test2.setEmail("test@gmail");
        test2.setImageSrc("test img src");
        test2.setTotalReviews("test total reviews");
        try {
            service.create(test);
            fail();
        } catch (NullHostIDException | InvalidHostNameException | InvalidHostIDException e) {
            fail();
        } catch (InvalidHostEmailException e) {

        }
    }

    @Test
    public void createHostInvalidName(){
        Host test = new Host();
        test.setHostName("test name1234");
        test.setSuperHost(true);
        test.setVerified(true);
        test.setResponseTime("test response time");
        test.setResponseRate(100.00);
        test.setJoinDate("May 2020");
        test.setEmail("test@email.com");
        test.setImageSrc("test img src");
        test.setTotalReviews("test total reviews");
        try {
            service.create(test);
            fail();
        } catch (NullHostIDException | InvalidHostEmailException | InvalidHostIDException e) {
            fail();
        } catch (InvalidHostNameException e) {

        }
    }

}
