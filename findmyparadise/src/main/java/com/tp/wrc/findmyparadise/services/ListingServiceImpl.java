package com.tp.wrc.findmyparadise.services;

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
    public Listing show(int id) {
        Optional<Listing> listing = repo.findById(id);
        if (listing.isPresent()) {
            return listing.get();
        } else {
            return null;
        }
    }

    @Override
    public Listing create(Listing listing) {
        return repo.saveAndFlush(listing);
    }

    @Override
    public boolean destroy(int id) {
        Listing listing = repo.findById(id).get();
        if (listing != null) {
            repo.delete(listing);
            return true;
        } else {
            return false;
        }
    }
}
