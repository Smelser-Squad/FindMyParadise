package com.tp.wrc.findmyparadise.models;

import com.tp.wrc.findmyparadise.exceptions.InvalidHostIDException;
import com.tp.wrc.findmyparadise.exceptions.NullHostIDException;
import com.tp.wrc.findmyparadise.repositories.HostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class HostTest {

    //TODO: fix table incrementing after each test

    @Autowired
    HostRepository repo;

    //workaround to table id's not reseting after each test
    int id1;
    int id2;

    @BeforeEach
    public void setup() {
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

        repo.save(test);

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

        repo.save(test2);

        id1 = test.getHostID();
        id2 = test2.getHostID();

    }

    @Test //Testing retrieving a host by ID. Two entries to ensure they get added correctly
    public void findHostByIdTestGoldenPath() {
        Optional<Host> test = repo.findById(id1);

        assertEquals("test name", test.get().getHostName());
        assertTrue(test.get().isSuperHost());
        assertTrue(test.get().isVerified());
        assertEquals("test response time", test.get().getResponseTime());
        assertEquals(100.00, test.get().getResponseRate());
        assertEquals("May 2020", test.get().getJoinDate());
        assertEquals("test@email.com", test.get().getEmail());
        assertEquals("test img src", test.get().getImageSrc());
        assertEquals("test total reviews", test.get().getTotalReviews());
        assertEquals("test@email.com", test.get().getEmail());

        test = repo.findById(id2);

        assertEquals("different test name", test.get().getHostName());
        assertFalse(test.get().isSuperHost());
        assertFalse(test.get().isVerified());
        assertEquals("different test response time", test.get().getResponseTime());
        assertEquals(500.2, test.get().getResponseRate());
        assertEquals("October 1990", test.get().getJoinDate());
        assertEquals("sample@gmail.com", test.get().getEmail());
        assertEquals("different test img src", test.get().getImageSrc());
        assertEquals("different test total reviews", test.get().getTotalReviews());


    }

    @Test //testing to make sure all hosts are retrieved from database and stored in list correctly
    void getAllGoldenPath() throws NullHostIDException, InvalidHostIDException {
        List<Host> allHosts = repo.findAll();

        assertEquals("test name", allHosts.get(2).getHostName());
        assertTrue(allHosts.get(2).isSuperHost());
        assertTrue(allHosts.get(2).isVerified());
        assertEquals("test response time", allHosts.get(2).getResponseTime());
        assertEquals(100.00, allHosts.get(2).getResponseRate());
        assertEquals("May 2020", allHosts.get(2).getJoinDate());
        assertEquals("test@email.com", allHosts.get(2).getEmail());
        assertEquals("test img src", allHosts.get(2).getImageSrc());
        assertEquals("test total reviews", allHosts.get(2).getTotalReviews());
        assertEquals("test@email.com", allHosts.get(2).getEmail());

        assertEquals("different test name", allHosts.get(3).getHostName());
        assertFalse(allHosts.get(3).isSuperHost());
        assertFalse(allHosts.get(3).isVerified());
        assertEquals("different test response time", allHosts.get(3).getResponseTime());
        assertEquals(500.2, allHosts.get(3).getResponseRate());
        assertEquals("October 1990", allHosts.get(3).getJoinDate());
        assertEquals("sample@gmail.com", allHosts.get(3).getEmail());
        assertEquals("different test img src", allHosts.get(3).getImageSrc());
        assertEquals("different test total reviews", allHosts.get(3).getTotalReviews());

    }


}