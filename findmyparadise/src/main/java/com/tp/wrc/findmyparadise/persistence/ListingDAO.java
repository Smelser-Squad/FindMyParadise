package com.tp.wrc.findmyparadise.persistence;

import com.tp.wrc.findmyparadise.models.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListingDAO extends JpaRepository<Listing, Integer> {

    //get all listings
    //find listing by ID
    //find listing by the name
    //find listing by host ID
    //find listing by price?
    //delete a listing by the ID
    //edit a listing by ID

}
