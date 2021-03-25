package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.models.Photo;
import com.tp.wrc.findmyparadise.repositories.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoGalleryServiceImpl implements PhotoGalleryService {

    @Autowired
    PhotoRepository PRepo;

    //TODO: implement logic here
    public String getById(Integer id) {
        return "Placeholder";
    }

    public Photo[] getByListing(Integer listingId) {
        return null;
    }

    public Photo[] getByListingAndCategory(Integer listingId, Integer categoryId) {
        return null;
    }

    public Integer addImage(Photo toAdd) {
        return null;
    }

    public boolean delete(Integer imageId) {
        return false;
    }
}
