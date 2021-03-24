package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.models.Amenity;

import java.util.List;

public interface AmenityService {

    public List<Amenity> getAllAmenities();
    public Amenity getAmenityById(Integer id);

}
