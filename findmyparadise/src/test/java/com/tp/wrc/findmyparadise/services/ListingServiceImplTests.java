package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.exceptions.*;
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
    ListingServiceImpl test;


    @Test
    public void createListingTest() {
        Listing listing = new Listing();
        listing.setListingID(1);
        listing.setName("Listing 1");
        listing.setAddress("123 Fake Address");
        listing.setPrice(60.00);

        try {
            test.create(listing, 1);
        }
        catch (NullHostIDException | InvalidHostIDException e)
        {
            fail();
        }
        assertEquals(listing.getListingID(),1);
        assertEquals(listing.getHost().getHostID(),1);
        assertEquals(listing.getName(),"Listing 1");
        assertEquals(listing.getAddress(),"123 Fake Address");
        assertEquals(listing.getPrice(),60.00);
    }

//    @Test
//    public void createListingTestNullListingID()
//    {
//        assertThrows(NullListingIDException.class,);
//    }
//
//    @Test
//    public void createListingTestNullHostID()
//    {
//        assertThrows(NullHostIDException.class, );
//    }
//
//    @Test
//    public void createListingTestNullListingName()
//    {
//        assertThrows(NoListingFoundException.class,);
//    }
//
//    @Test
//    public void createListingTestNullAddress()
//    {
//        assertThrows(NullAddressException.class,);
//
//    }

    @Test
    public void createListingTestNullPrice()
    {
//        assertThrows(NullListingPriceException.class,);
    }

    @Test
    public void getAllListingsTest()
    {

    }

    @Test
    public void getListingTest()
    {

    }

    @Test
    public void getListingByNameTest()
    {

    }

    @Test
    public void getListingByTypeTest()
    {

    }

    @Test
    public void getListingsByHostIDTest()
    {

    }

}
