package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.exceptions.*;
import com.tp.wrc.findmyparadise.models.Listing;

import java.util.List;

public interface ListingService {

     List<Listing> index();
     Listing show(Integer id) throws NoListingFoundException;
     Listing create(Listing listing);
     boolean destroy(Integer id) throws NullListingIDException;
     Listing update(Integer id, Listing newListing) throws NullListingIDException, NoListingFoundException;
     List<Listing> findByNameIgnoreCase(String listingName) throws NoListingFoundException, InvalidListingNameException;
     List<Listing> findByHostID(Integer hostID) throws NullHostIDException, InvalidHostIDException;
     List<Listing> findByPrice(Double price) throws NoListingFoundException;
     List<Listing> findByType(String type) throws NoListingFoundException;


}
