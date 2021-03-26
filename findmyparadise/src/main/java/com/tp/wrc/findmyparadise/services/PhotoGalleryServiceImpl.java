package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.models.Photo;
import com.tp.wrc.findmyparadise.repositories.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoGalleryServiceImpl implements PhotoGalleryService {

    @Autowired
    PhotoRepository PRepo;


    public Photo getById(Integer id) {
        Photo photo = null;
        Optional<Photo> opt = PRepo.findById(id);
        if(opt.isPresent()){
            photo = opt.get();
            return photo;
        }
        return null;
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
        Photo photo = null;
        Optional<Photo> opt = PRepo.findById(imageId);
        if(opt.isPresent()){
            photo = opt.get();
            PRepo.delete(photo);
            return true;
        }
        return false;
    }
}
