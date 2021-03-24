package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.models.Amenity;
import com.tp.wrc.findmyparadise.models.Event;
import com.tp.wrc.findmyparadise.repositories.AmenityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AmenityServiceImpl implements AmenityService {

    @Autowired
    AmenityRepository amenityRepository;

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
}
