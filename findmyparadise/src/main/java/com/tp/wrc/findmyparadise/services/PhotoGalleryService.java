package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.models.Photo;

public interface PhotoGalleryService {

    String getById(Integer id);

    Photo[] getByListing(Integer listingId);

    Photo[] getByListingAndCategory(Integer listingId, Integer categoryId);

    Integer addImage(Photo toAdd);

    boolean delete(Integer imageId);

}
