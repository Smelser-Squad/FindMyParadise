package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.exceptions.InvalidAmenityIdException;
import com.tp.wrc.findmyparadise.exceptions.NullAmenityIdException;
import com.tp.wrc.findmyparadise.exceptions.NullCategoryException;
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
        return amenityRepository.saveAndFlush(amenity);
    }

    @Override
    public List<Amenity> getAllAmenities() {
        return amenityRepository.findAll();

    }

    @Override
    public Amenity findAmenityById(Integer id) throws NullAmenityIdException, InvalidAmenityIdException {
        if(id == null)
            throw new NullAmenityIdException("Amenity ID is null.");

        Amenity amenity = null;
        Optional<Amenity> opt = amenityRepository.findById(id);
        if (opt.isPresent()) {
            amenity = opt.get();

            return amenity;
        }
        else {
            throw new InvalidAmenityIdException("Amenity does not exist.");
        }

    }

    @Override
    public List<Amenity> findAmenityByCategory(String category) throws NullCategoryException{
        if(category == null)
            throw new NullCategoryException("Category is null.");

        List<Amenity> amenities = amenityRepository.findByCategory(category);

        return amenities;
    }

    @Override
    public Amenity update(Amenity amenity) throws NullAmenityIdException, InvalidAmenityIdException{
        if(amenity.getAmenityId() == null)
            throw new NullAmenityIdException("Amenity ID is null.");

        Amenity toUpdate = amenityRepository.findById(amenity.getAmenityId()).get();

        if(toUpdate != null) {

            toUpdate.setAmenityName(amenity.getAmenityName());
            toUpdate.setAmenityCategory(amenity.getAmenityCategory());

            return amenityRepository.saveAndFlush(toUpdate);
        }
        else {
            throw new InvalidAmenityIdException("Amenity does not exist.");
        }

    }

    @Override
    public boolean destroy(Integer id) throws NullAmenityIdException, InvalidAmenityIdException{
        if(id == null)
            throw new NullAmenityIdException("Amenity ID is null.");

        Amenity amenity = amenityRepository.findById(id).get();

        if (amenity != null) {
            amenityRepository.delete(amenity);
            return true;
        }
        else {
            throw new InvalidAmenityIdException("Amenity does not exist.");
        }

    }
}
