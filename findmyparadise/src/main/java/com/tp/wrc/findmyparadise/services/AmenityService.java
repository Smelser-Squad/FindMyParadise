package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.exceptions.InvalidAmenityIdException;
import com.tp.wrc.findmyparadise.exceptions.NullAmenityIdException;
import com.tp.wrc.findmyparadise.models.Amenity;
import com.tp.wrc.findmyparadise.models.Event;

import java.util.List;

public interface AmenityService {

    public Amenity create(Amenity amenity);

    public List<Amenity> getAllAmenities();

    public Amenity findAmenityById(Integer id) throws NullAmenityIdException, InvalidAmenityIdException;

    public List<Amenity> findAmenityByCategory(String category);

    public Amenity update(Amenity event) throws NullAmenityIdException, InvalidAmenityIdException;

    public boolean destroy(Integer id) throws NullAmenityIdException, InvalidAmenityIdException;

}
