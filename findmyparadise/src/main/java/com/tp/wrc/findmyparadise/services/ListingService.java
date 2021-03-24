package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.exceptions.NoListingFoundException;
import com.tp.wrc.findmyparadise.models.Listing;

import java.util.List;

public interface ListingService {

     List<Listing> index();
     Listing show(int id) throws NoListingFoundException;
     Listing create(Listing listing);
     boolean destroy(int id);
     Listing findByName(String name);
     List<Listing> findByHostID(Integer hostID);
     List<Listing> findByPrice(Double price);



}
