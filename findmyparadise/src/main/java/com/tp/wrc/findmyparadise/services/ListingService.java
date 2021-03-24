package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.exceptions.InvalidListingIDException;
import com.tp.wrc.findmyparadise.exceptions.NoListingFoundException;
import com.tp.wrc.findmyparadise.exceptions.NullListingIDException;
import com.tp.wrc.findmyparadise.models.Listing;

import java.util.List;

public interface ListingService {
    public List<Listing> index();

    public Listing show(Integer id) throws NoListingFoundException, NullListingIDException;

    public Listing create(Listing Listing) throws NullListingIDException;

    public boolean destroy(int id);
}
