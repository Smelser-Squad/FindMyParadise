package com.tp.wrc.findmyparadise.repositories;

import com.tp.wrc.findmyparadise.models.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListingRepository extends JpaRepository<Listing, Integer> {
    
}
