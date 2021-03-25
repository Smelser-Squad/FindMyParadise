package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.exceptions.NoListingFoundException;
import com.tp.wrc.findmyparadise.models.Listing;
import com.tp.wrc.findmyparadise.repositories.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListingServiceImpl implements ListingService {

    @Autowired
    private ListingRepository repo;

    @Override
    public List<Listing> index() {
        return repo.findAll();
    }

    @Override
    public Listing show(Integer id) throws NoListingFoundException {
        Listing listing = repo.findById(id).orElseThrow(() -> new NoListingFoundException("No listing found"));
        return listing;
    }

    @Override
    public Listing create(Listing listing) {
        return repo.saveAndFlush(listing);
    }

    @Override
    public boolean destroy(Integer id) {
        Listing listing = repo.findById(id).get();
        if (listing != null) {
            repo.delete(listing);
            return true;
        } else {
            return false;
        }
    }
  
//    TODO: implement these methods
//    @Override
//    public List<Listing> findByListingNameIgnoreCase(String listingName)  throws NoListingFoundException, InvalidListingNameException {
//        return null;
//    }

//    @Override
//    public List<Listing> findByHostID(Integer hostID){

//    @Override
//    public List<Listing> findByPrice(Double price) {
//        return null;
//    }




