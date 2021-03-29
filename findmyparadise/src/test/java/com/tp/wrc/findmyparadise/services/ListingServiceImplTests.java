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
        try {
            listing = test.create(listing, 1);
        }
        catch (NullHostIDException | InvalidHostIDException e)
        {
            fail();
        }
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

    public void getAllListingsTest()
    {

    }

    public void getListingTest()
    {

    }

    public void getListingByNameTest()
    {

    }

    public void getListingByTypeTest()
    {

    }

    public void getListingsByHostIDTest()
    {

    }

}
