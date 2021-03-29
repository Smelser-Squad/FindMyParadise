package com.tp.wrc.findmyparadise.models;

import com.tp.wrc.findmyparadise.exceptions.InvalidHostEmailException;
import com.tp.wrc.findmyparadise.exceptions.InvalidHostIDException;
import com.tp.wrc.findmyparadise.exceptions.InvalidHostNameException;
import com.tp.wrc.findmyparadise.exceptions.NullHostIDException;
import com.tp.wrc.findmyparadise.services.EventServiceImpl;
import com.tp.wrc.findmyparadise.services.HostServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class HostTest {

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
        } catch (NullHostIDException | InvalidHostIDException | InvalidHostEmailException | InvalidHostNameException e){
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

            //21 because this runs after all the other tests have added to the list
            //need to manually change if tests are added or deleted
            assertEquals(21,allHosts.size());
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