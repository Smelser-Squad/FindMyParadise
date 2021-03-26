package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.models.Photo;
import com.tp.wrc.findmyparadise.repositories.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoGalleryServiceImpl implements PhotoGalleryService {

    @Autowired
    PhotoRepository PRepo;


    public Photo getById(Integer id) {
        return PRepo.findById(id).get();
    }

    public List<Photo> getByListing(Integer listingId) {
        return PRepo.findByListing(listingId);
    }

    //This method may not be necessary
//    @Override
//    public List<Photo> getByListingAndCategory(Integer listingId, Integer categoryId) {
//        return null;
//    }

    public Photo addImage(Photo toAdd) {
        return PRepo.saveAndFlush(toAdd);
    }

    public boolean delete(Integer imageId) {
        Photo photo = PRepo.findById(imageId).get();
        if(photo != null){
            PRepo.delete(photo);
            return true;
        }
        return false;
    }
}
