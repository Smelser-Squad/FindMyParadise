package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.exceptions.NoListingFoundException;
import com.tp.wrc.findmyparadise.models.Listing;

import java.util.List;

public interface ListingService {

     List<Listing> index();
     Listing show(Integer id) throws NoListingFoundException;
     Listing create(Listing listing);
     boolean destroy(Integer id);
     Listing findByListingNameIgnoreCase(String listingName) throws NoListingFoundException;
//     List<Listing> findByHostID(Integer hostID) throws NullHostIDException, InvalidHostException;
//     List<Listing> findByPrice(Double price) throws NoListingFoundException;


}
