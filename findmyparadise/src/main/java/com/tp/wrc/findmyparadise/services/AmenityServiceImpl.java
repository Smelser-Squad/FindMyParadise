package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.models.Amenity;
import com.tp.wrc.findmyparadise.models.Event;
import com.tp.wrc.findmyparadise.repositories.AmenityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AmenityServiceImpl implements AmenityService {

    @Autowired
    AmenityRepository amenityRepository;

    @Override
    public Amenity create(Amenity amenity) {
        return null;
    }

    @Override
    public List<Amenity> getAllAmenities() {
        return amenityRepository.findAll();

    }

    @Override
    public Amenity getAmenityById(Integer id) {
        Amenity amenity = null;
        Optional<Amenity> opt = amenityRepository.findById(id);
        if (opt.isPresent()) {
            amenity = opt.get();

            return amenity;
        }
        return null;
    }

    @Override
    public Amenity getAmenityByCategory(String category) {
        Amenity amenity = amenityRepository.findByCategory(category);

        return amenity;
    }

    @Override
    public Amenity update(Amenity amenity) {
        Amenity toUpdate = amenityRepository.findById(amenity.getAmenityId()).get();

        if(toUpdate != null) {

            toUpdate.setAmenityName(amenity.getAmenityName());
            toUpdate.setAmenityCategory(amenity.getAmenityCategory());

            return amenityRepository.saveAndFlush(toUpdate);
        }

        return null;
    }

    @Override
    public boolean destroy(Integer id) {
        Amenity amenity = amenityRepository.findById(id).get();

        if (amenity != null) {
            amenityRepository.delete(amenity);
            return true;
        }

        return false;
    }
}
