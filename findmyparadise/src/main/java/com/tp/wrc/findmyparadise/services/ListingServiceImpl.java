package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.exceptions.*;
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
    public boolean destroy(Integer id) throws NullListingIDException {
        if (id == null) {
            throw new NullListingIDException("Listing ID cannot be null");
        }
        Listing listing = repo.findById(id).get();
        if (listing != null) {
            repo.delete(listing);
            return true;
        } else {
            return false;
        }
    }
    @Override
    public Listing update(Integer id, Listing newListing) throws NullListingIDException, NoListingFoundException {
        if (id == null) {
            throw new NullListingIDException("Listing ID cannot be null");
        }
        newListing.setListingID(id);
        return repo.save(newListing);
    }

    @Override
    public List<Listing> findByNameIgnoreCase(String listingName)  throws NoListingFoundException, InvalidListingNameException {
        return repo.findByNameIgnoreCase(listingName);
    }
    
    @Override
    public List<Listing> findByHostID(Integer hostID) throws NullHostIDException, InvalidHostIDException {
        return repo.findByHost(hostID);
    }

    @Override
    public List<Listing> findByPrice(Double price) {
        return repo.findByPrice(price);
    }

    @Override
    public List<Listing> findByType(String type) throws NoListingFoundException {
        return repo.findByType(type);
    }

}

