package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.exceptions.NoListingFoundException;
import com.tp.wrc.findmyparadise.models.Photo;

import java.util.List;

public interface PhotoGalleryService {

    Photo getById(Integer id);

    List<Photo> getByListing(Integer listingId) throws NoListingFoundException;

    //List<Photo> getByListingAndCategory(Integer listingId, Integer categoryId);

    Photo addImage(Photo toAdd, Integer listingId) throws NoListingFoundException;

    boolean delete(Integer imageId);

}
