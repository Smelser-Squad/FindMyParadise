package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.models.Photo;

import java.util.List;

public interface PhotoGalleryService {

    Photo getById(Integer id);

    List<Photo> getByListing(Integer listingId);

    //List<Photo> getByListingAndCategory(Integer listingId, Integer categoryId);

    Photo addImage(Photo toAdd);

    boolean delete(Integer imageId);

}
