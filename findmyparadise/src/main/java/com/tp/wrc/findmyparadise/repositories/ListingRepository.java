package com.tp.wrc.findmyparadise.repositories;

import com.tp.wrc.findmyparadise.models.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Integer> {




//    Listing findByName(String name);
    List<Listing> findByNameIgnoreCase(String name);


//    //find listing by host ID

    List<Listing> findByHostHostID(Integer hostID);



    //find listing by price
    List<Listing> findByPrice(Double price);
    //find by type
    List<Listing> findByType(String type);

}
