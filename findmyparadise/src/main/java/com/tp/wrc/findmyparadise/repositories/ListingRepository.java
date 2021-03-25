package com.tp.wrc.findmyparadise.repositories;

import com.tp.wrc.findmyparadise.models.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Integer> {

    Optional<List<Listing>> findByListingNameIgnoreCase(String listingName);
//    //find listing by host ID
//    List<Listing> findByHostID(Integer hostID);
//    //find listing by price?
//    List<Listing> findByPrice(Double price);

}
