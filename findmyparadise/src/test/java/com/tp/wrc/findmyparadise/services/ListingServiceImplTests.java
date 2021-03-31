package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.exceptions.*;
import com.tp.wrc.findmyparadise.models.Listing;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ListingServiceImplTests {

    @Autowired
    ListingServiceImpl test;

    @BeforeEach()
    public void setup() throws InvalidHostIDException, NullListingPriceException, NullAddressException, NullHostIDException, NullListingNameException, InvalidListingNameException, InvalidAddressException {
        Listing listing = new Listing();
        listing.setListingId(1);
        listing.setName("Listing 1");
        listing.setAddress("123 Fake Address");
        listing.setPrice(60.00);
        test.create(listing, 1);
    }

    @Test
    @Order(1)
    public void createListingTest() {

        Listing listing2 = new Listing();
        listing2.setListingId(2);
        listing2.setName("Listing 2");
        listing2.setAddress("567 Test Address");
        listing2.setPrice(20.00);

        try {
            test.create(listing2, 1);
        }
        catch (NullHostIDException | InvalidHostIDException | NullListingNameException | InvalidListingNameException | NullAddressException | InvalidAddressException | NullListingPriceException e)
        {
            fail();
        }
        assertEquals(2,listing2.getListingId());
        assertEquals(1, listing2.getHost().getHostID());
        assertEquals("Listing 2",listing2.getName());
        assertEquals("567 Test Address",listing2.getAddress());
        assertEquals(20.00,listing2.getPrice());
    }

    @Test
    public void createListingTestNullHostID()
    {
        Listing listing = new Listing();
        listing.setListingId(1);
        listing.setName("Listing 1");
        listing.setAddress("123 Fake Address");
        listing.setPrice(60.00);
        assertThrows(NullHostIDException.class, () -> test.create(listing,null));
    }

    @Test
    public void createListingTestNullListingName()
    {
        Listing listing = new Listing();
        listing.setListingId(1);
        listing.setName(null);
        listing.setAddress("123 Fake Address");
        listing.setPrice(60.00);
        assertThrows(NullListingNameException.class, () -> test.create(listing,1));
    }

    @Test
    public void createListingTestNullAddress()
    {
        Listing listing = new Listing();
        listing.setListingId(1);
        listing.setName("Listing 1");
        listing.setAddress(null);
        listing.setPrice(60.00);
        assertThrows(NullAddressException.class,() -> test.create(listing,1));

    }

    @Test
    public void createListingTestNullPrice()
    {
        Listing listing = new Listing();
        listing.setListingId(1);
        listing.setName("Listing 1");
        listing.setAddress("123 Fake Address");
        listing.setPrice(null);
        assertThrows(NullListingPriceException.class, () -> test.create(listing,1));
    }

    @Test
    public void getAllListingsTest()
    {
        List<Listing> allListings = test.index();
        assertEquals("Listing 1",allListings.get(0).getName());
        assertEquals("123 Fake Address",allListings.get(0).getAddress());
    }

    @Test
    public void getListingTest() throws NoListingFoundException {
        Listing listing = test.show(1);
        assertEquals("Listing 1",listing.getName());
        assertEquals("123 Fake Address",listing.getAddress());

    }

    @Test
    public void getListingByNameTest() throws InvalidListingNameException, NoListingFoundException, NullListingNameException {
        List<Listing> listings = test.findByNameIgnoreCase("listing 1");
        assertEquals("Listing 1",listings.get(0).getName());

    }

    @Test
    @Order(2)
    public void getListingsByTypeTest() throws NoListingFoundException, InvalidHostIDException, NullListingPriceException, NullAddressException, NullHostIDException, NullListingNameException, InvalidListingNameException, InvalidAddressException {
        Listing listing = new Listing();
        listing.setListingId(3);
        listing.setName("Listing 3");
        listing.setAddress("12345 Street");
        listing.setPrice(80.00);
        listing.setType("House");
        test.create(listing, 1);
        List<Listing> allListings = test.findByType("House");
        assertEquals(1, allListings.get(0).getHost().getHostID());
        assertEquals("12345 Street",allListings.get(0).getAddress());
        assertEquals(80.00, allListings.get(0).getPrice());
    }

    @Test
    public void getListingsByHostIDTest() throws InvalidHostIDException, NullHostIDException {

        List<Listing> listings = test.findByHostID(1);
        assertEquals("Listing 1",listings.get(0).getName());
        assertEquals(60.00,listings.get(0).getPrice());
    }



    @Test
    @Order(3)
    public void deleteListingTest() throws InvalidHostIDException, NullListingPriceException, NullAddressException, NullHostIDException, NullListingNameException, InvalidListingNameException, InvalidAddressException, NoListingFoundException, NullListingIDException {
        Listing toDelete = new Listing();
        toDelete.setListingId(4);
        toDelete.setName("Listing 4");
        toDelete.setAddress("To Delete Street");
        toDelete.setPrice(75.00);
        toDelete.setType("Mansion");
        test.create(toDelete,1);
        assertEquals("Listing 4",test.show(4).getName());

        test.destroy(4);
        assertThrows(NoListingFoundException.class,() ->test.show(4).getName());
    }

    @Test
    @Order(4)
    public void updateListingTest() throws InvalidHostIDException, NullListingPriceException, NullAddressException, NullHostIDException, NullListingNameException, InvalidListingNameException, InvalidAddressException, NoListingFoundException, NullListingIDException {
        Listing toUpdate = new Listing();
        toUpdate.setListingId(5);
        toUpdate.setName("Listing 5");
        toUpdate.setAddress("To Update Street");
        toUpdate.setPrice(75.00);
        toUpdate.setType("Condo");
        test.create(toUpdate,1);

        assertEquals("Listing 5",test.show(5).getName());
        toUpdate.setName("NEW Listing 5");
        
        test.update(toUpdate.getListingId(),toUpdate);
        assertEquals("NEW Listing 5",test.show(5).getName());

    }

}

