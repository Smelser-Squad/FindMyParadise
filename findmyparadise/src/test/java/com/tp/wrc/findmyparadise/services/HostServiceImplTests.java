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
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class HostServiceImplTests {

    @Autowired
    HostServiceImpl service;

    @BeforeEach
    public void setup() {
        Host test = new Host();

        try {
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
            Host test2 = new Host();
            test2.setHostName("different test name");
            test2.setSuperHost(false);
            test2.setVerified(false);
            test2.setResponseTime("different test response time");
            test2.setResponseRate(500.2);
            test2.setJoinDate("October 1990");
            test2.setEmail("sample@gmail.com");
            test2.setImageSrc("different test img src");
            test2.setTotalReviews("different test total reviews");
            service.create(test2);
        } catch (NullHostIDException | InvalidHostIDException e){
            fail();
        }
    }

    @Test //Testing retrieving a host by ID. Two entries to ensure they get added correctly
    public void findHostByIdTestGoldenPath() {
        try {
            Host test = service.show(1);
            assertEquals("test name", test.getHostName());
            assertTrue(test.isSuperHost());
            assertTrue(test.isVerified());
            assertEquals("test response time", test.getResponseTime());
            assertEquals(100.00, test.getResponseRate());
            assertEquals("May 2020", test.getJoinDate());
            assertEquals("test@email.com", test.getEmail());
            assertEquals("test img src", test.getImageSrc());
            assertEquals("test total reviews", test.getTotalReviews());
            assertEquals("test@email.com", test.getEmail());
            test = service.show(2);
            assertEquals("different test name", test.getHostName());
            assertFalse(test.isSuperHost());
            assertFalse(test.isVerified());
            assertEquals("different test response time", test.getResponseTime());
            assertEquals(500.2, test.getResponseRate());
            assertEquals("October 1990", test.getJoinDate());
            assertEquals("sample@gmail.com", test.getEmail());
            assertEquals("different test img src", test.getImageSrc());
            assertEquals("different test total reviews", test.getTotalReviews());
        } catch (NullHostIDException | InvalidHostIDException e){
            fail();
        }

    }

    @Test //testing to make sure all hosts are retrieved from database and stored in list correctly
    void getAllGoldenPath() throws NullHostIDException, InvalidHostIDException {
        try {
            List<Host> allHosts = service.getAll();

            assertEquals("test name", allHosts.get(0).getHostName());
            assertTrue(allHosts.get(0).isSuperHost());
            assertTrue(allHosts.get(0).isVerified());
            assertEquals("test response time", allHosts.get(0).getResponseTime());
            assertEquals(100.00, allHosts.get(0).getResponseRate());
            assertEquals("May 2020", allHosts.get(0).getJoinDate());
            assertEquals("test@email.com", allHosts.get(0).getEmail());
            assertEquals("test img src", allHosts.get(0).getImageSrc());
            assertEquals("test total reviews", allHosts.get(0).getTotalReviews());
            assertEquals("test@email.com", allHosts.get(0).getEmail());

            assertEquals("different test name", allHosts.get(1).getHostName());
            assertFalse(allHosts.get(1).isSuperHost());
            assertFalse(allHosts.get(1).isVerified());
            assertEquals("different test response time", allHosts.get(1).getResponseTime());
            assertEquals(500.2, allHosts.get(1).getResponseRate());
            assertEquals("October 1990", allHosts.get(1).getJoinDate());
            assertEquals("sample@gmail.com", allHosts.get(1).getEmail());
            assertEquals("different test img src", allHosts.get(1).getImageSrc());
            assertEquals("different test total reviews", allHosts.get(1).getTotalReviews());
        } catch (NullHostIDException | InvalidHostIDException e){
            fail();
        }
    }

    @Test //testing show method to ensure that data can be retrieved correctly from db
    void showGoldenPath() {

        Host test = new Host();

        try {
            test = service.show(1);
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


        } catch (NullHostIDException | InvalidHostIDException e){
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

    @Test //testing create to ensure that data can be updated correctly to db
    void updateGoldenPath() {

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


        Host newHost = new Host();

        newHost.setHostName("test name");
        newHost.setSuperHost(true);
        newHost.setVerified(true);
        newHost.setResponseTime("test response time");
        newHost.setResponseRate(100.00);
        newHost.setJoinDate("May 2020");
        newHost.setEmail("test@email.com");
        newHost.setImageSrc("test img src");
        newHost.setTotalReviews("test total reviews");

        try {
            service.create(test);
            service.update(newHost);
        } catch (InvalidHostIDException | NullHostIDException e) {
            fail();
        }

    }

    @Test //testing create to ensure that data can be deleted correctly from the db
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
        } catch (NullHostIDException | InvalidHostIDException e) {
            fail();
        }


    }

    


}
