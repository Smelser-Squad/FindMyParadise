package com.tp.wrc.findmyparadise.repositories;

import com.tp.wrc.findmyparadise.models.Listing;
import com.tp.wrc.findmyparadise.models.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotoRepository extends JpaRepository< Photo, Integer> {

    List<Photo> findByListing(Listing listingId);
    //List<Photo> findByListingId(Integer listingId, String Category);

}
