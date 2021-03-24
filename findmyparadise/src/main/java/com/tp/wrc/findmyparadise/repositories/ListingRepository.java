package com.tp.wrc.findmyparadise.repositories;

import com.tp.wrc.findmyparadise.models.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Integer> {

    //get all listings
    //find listing by ID
    //find listing by the name
    //find listing by host ID
    //find listing by price?
    //delete a listing by the ID
    //edit a listing by ID
    
}
