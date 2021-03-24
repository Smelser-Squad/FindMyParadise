package com.tp.wrc.findmyparadise.persistence;

import com.tp.wrc.findmyparadise.models.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListingDAO extends JpaRepository<Listing, Integer> {

}
