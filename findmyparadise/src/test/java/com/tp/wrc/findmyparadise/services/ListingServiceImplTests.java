package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.models.Host;
import com.tp.wrc.findmyparadise.models.Listing;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
public class ListingServiceImplTests {

    @Autowired
    ListingServiceImpl service;

    @BeforeEach
    public void setup() {
        Listing listing = new Listing();
        listing.setName("Listing Name");
        listing.setLatitude(1.1);
        listing.setLongitude(2.2);
        listing.setAddress("Listing Address");
        listing.setDescription("Listing Description");
        listing.setPrice(9.99);
        listing.setMaxGuests(4);
        listing.setServiceFee(11.0);
        listing.setOccupancyFee(22.0);
        listing.setCleaningFee(33.0);
        listing.setBedrooms(2);
        listing.setBathrooms(2);
        listing.setBeds(2);
        listing.setType("Listing Type");

        Host host = new Host();
        host.setHostName("Host Name");
        host.setTotalReviews("3 reviews");
        host.setSuperHost(true);
        host.setVerified(true);
        host.setResponseTime("Host Response Time");
        host.setResponseRate(0.8);
        host.setJoinDate("2021-11-11");
        host.setEmail("Host Email");
        host.setImageSrc("Host Image");
        listing.setHost(host);

        service.create(listing);
    }

    @Test
    public void testIndexGoldenPath() {
        List<Listing> listings = service.index();
        assertEquals(1, listings.size());
        Listing listing = listings.get(0);

        assertEquals(1, listing.getListingID());
        assertEquals("Listing Name", listing.getName());
        assertEquals(1.1, listing.getLatitude());
        assertEquals(2.2, listing.getLongitude());
        assertEquals("Listing Address", listing.getAddress());
        assertEquals("Listing Description", listing.getDescription());
        assertEquals(9.99, listing.getPrice());
        assertEquals(4, listing.getMaxGuests());
        assertEquals(11.0, listing.getServiceFee());
        assertEquals(22.0, listing.getOccupancyFee());
        assertEquals(33.0, listing.getCleaningFee());
        assertEquals(0, listing.getReviews().size());
        assertEquals(0, listing.getReservations().size());
        assertEquals(2, listing.getBedrooms());
        assertEquals(2, listing.getBathrooms());
        assertEquals(2, listing.getBeds());
        assertEquals("Listing Type", listing.getType());
        assertEquals(0, listing.getAmenities().size());

        Host host = listing.getHost();
        assertEquals(1, host.getHostID());
        assertEquals("Host Name", host.getHostName());
        assertEquals("3 reviews", host.getTotalReviews());
        assertTrue(host.isSuperHost());
        assertTrue(host.isVerified());
        assertEquals("Host Response Time", host.getResponseTime());
        assertEquals(0.8, host.getResponseRate());
        assertEquals("2011-11-11", host.getJoinDate());
        assertEquals("Host Email", host.getEmail());
        assertEquals("Host Image", host.getImageSrc());
    }
}
