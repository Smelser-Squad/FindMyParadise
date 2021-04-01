package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.exceptions.*;
import com.tp.wrc.findmyparadise.models.Listing;

import java.util.List;

public interface ListingService {

     List<Listing> index();
     Listing show(Integer id) throws NoListingFoundException;
     Listing create(Listing listing, Integer hostID) throws InvalidHostIDException, NullHostIDException, NullListingNameException, InvalidListingNameException, NullAddressException, InvalidAddressException, NullListingPriceException;
     boolean destroy(Integer id) throws NullListingIDException;
     Listing update(Integer id, Listing newListing) throws NullListingIDException, NoListingFoundException;
     List<Listing> findByNameIgnoreCase(String listingName) throws NoListingFoundException, InvalidListingNameException, NullListingNameException;
     List<Listing> findByHostID(Integer hostID) throws NullHostIDException, InvalidHostIDException;
     List<Listing> findByPrice(Double price) throws NoListingFoundException, NullListingPriceException;
     List<Listing> findByType(String type) throws NoListingFoundException, NullListingTypeException, InvalidListingTypeException;

}
