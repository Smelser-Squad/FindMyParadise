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
import org.mockito.InjectMocks;
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

    @Test //testing show method to ensure that data can be retrieved correctly from db
    void showGoldenPath() {

        Host test = new Host();

        try {
            test = service.show(4);
        } catch (NullHostIDException | InvalidHostIDException e){
            fail();
        }

        assertEquals("test name", test.getHostName());
        assertTrue(test.isSuperHost());
        assertTrue(test.isVerified());
        assertEquals("test response time", test.getResponseTime());
        assertEquals(100.00, test.getResponseRate());
        assertEquals("May 2020", test.getJoinDate());
        assertEquals("test@email.com", test.getEmail());
        assertEquals("test img src", test.getImageSrc());
        assertEquals("test total reviews", test.getTotalReviews());

    }

    @Test //testing create to ensure that data can be added correctly to db
    void createGoldenPath() {

        Host test = new Host();
        Host retrieved = new Host();

        try {
            test.setHostName("create test name");
            test.setSuperHost(true);
            test.setVerified(false);
            test.setResponseTime("create test response time");
            test.setResponseRate(100.00);
            test.setJoinDate("May 2020");
            test.setEmail("create@email.com");
            test.setImageSrc("create test img src");
            test.setTotalReviews("create test total reviews");


            service.create(test);
            retrieved = service.show(test.getHostID());


        } catch (NullHostIDException | InvalidHostIDException | InvalidHostEmailException | InvalidHostNameException e){
            System.out.print(e.getMessage());
            fail();
        }

        assertEquals("create test name", retrieved.getHostName());
        assertTrue(retrieved.isSuperHost());
        assertFalse(retrieved.isVerified());
        assertEquals("create test response time", retrieved.getResponseTime());
        assertEquals(100.00, retrieved.getResponseRate());
        assertEquals("May 2020", retrieved.getJoinDate());
        assertEquals("create@email.com", retrieved.getEmail());
        assertEquals("create test img src", retrieved.getImageSrc());
        assertEquals("create test total reviews", retrieved.getTotalReviews());
    }

    @Test //testing update to ensure that data can be updated correctly to db
    void updateGoldenPath() {

        Host original = new Host();

        original.setHostName("original name");
        original.setSuperHost(false);
        original.setVerified(false);
        original.setResponseTime("original response time");
        original.setResponseRate(200.00);
        original.setJoinDate("May 2020");
        original.setEmail("original@email.com");
        original.setImageSrc("original img src");
        original.setTotalReviews("original total reviews");

        Host updateHost = new Host();

        updateHost.setHostName("new name");
        updateHost.setSuperHost(true);
        updateHost.setVerified(true);
        updateHost.setResponseTime("new response time");
        updateHost.setResponseRate(100.00);
        updateHost.setJoinDate("May 2020");
        updateHost.setEmail("new@email.com");
        updateHost.setImageSrc("new img src");
        updateHost.setTotalReviews("new total reviews");


        try {
            service.create(original);
            updateHost.setHostID(original.getHostID());
            service.update(updateHost);
            original = service.show(original.getHostID());
        } catch (NullHostIDException | InvalidHostIDException | InvalidHostEmailException | InvalidHostNameException e) {
            fail();
        }


        assertEquals("new name", original.getHostName());
        assertTrue(original.isSuperHost());
        assertTrue(original.isVerified());
        assertEquals("new response time", original.getResponseTime());
        assertEquals(100.00, original.getResponseRate());
        assertEquals("May 2020", original.getJoinDate());
        assertEquals("new@email.com", original.getEmail());
        assertEquals("new img src", original.getImageSrc());
        assertEquals("new total reviews", original.getTotalReviews());

    }

    @Test //testing destroy to ensure that data can be deleted correctly from the db
    void destroyGoldenPath() {

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

        try {
            service.create(test);
            assertTrue(service.destroy(test.getHostID()));
        } catch (NullHostIDException | InvalidHostIDException | InvalidHostEmailException | InvalidHostNameException e) {
            fail();
        }


    }


    @Test
    public void showInvalidHostId() {

        assertThrows(InvalidHostIDException.class, ()-> service.show(Integer.MAX_VALUE));

    }

    @Test
    public void showNullHostId() {

        assertThrows(NullHostIDException.class, ()-> service.show(null));

    }

    @Test   //Throws NoSuchElementException instead of InvalidHostId exception because JPA already does some testing
    public void updateInvalidHostId() {

        Host invalid = new Host();
        invalid.setHostName("test name");
        invalid.setSuperHost(false);
        invalid.setVerified(false);
        invalid.setResponseTime("test response time");
        invalid.setResponseRate(100.00);
        invalid.setJoinDate("May 2020");
        invalid.setEmail("test@email.com");
        invalid.setImageSrc("test img src");
        invalid.setTotalReviews("test total reviews");

        invalid.setHostID(Integer.MAX_VALUE);

        assertThrows(NoSuchElementException.class, ()-> service.update(invalid));


    }

    @Test
    public void updateNullHostId() {

        Host invalid = new Host();
        invalid.setHostName("test name");
        invalid.setSuperHost(false);
        invalid.setVerified(false);
        invalid.setResponseTime("test response time");
        invalid.setResponseRate(100.00);
        invalid.setJoinDate("May 2020");
        invalid.setEmail("test@email.com");
        invalid.setImageSrc("test img src");
        invalid.setTotalReviews("test total reviews");

        invalid.setHostID(null);

        assertThrows(NullHostIDException.class, ()-> service.update(invalid));


    }

    @Test   //Throws NoSuchElementException instead of InvalidHostId exception because JPA already does some testing
    public void destroyInvalidHostId() {

        assertThrows(NoSuchElementException.class, ()-> service.destroy(Integer.MAX_VALUE));

    }

    @Test
    public void destroyNullHostId() {

        assertThrows(NullHostIDException.class, ()-> service.destroy(null));

}

}
