package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.models.Amenity;
import com.tp.wrc.findmyparadise.models.Event;

import java.util.List;

public interface AmenityService {

    public Amenity create(Amenity amenity);

    public List<Amenity> getAllAmenities();

    public Amenity getAmenityById(Integer id);

    public Amenity getAmenityByCategory(String category);

    public Amenity update(Amenity event);

    public boolean destroy(Integer id);

}
