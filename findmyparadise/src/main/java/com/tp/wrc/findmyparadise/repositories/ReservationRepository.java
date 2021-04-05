package com.tp.wrc.findmyparadise.repositories;

import com.tp.wrc.findmyparadise.exceptions.InvalidListingIDException;
import com.tp.wrc.findmyparadise.models.Listing;
import com.tp.wrc.findmyparadise.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    @Query("select r from Reservation r where r.listing=:listing")
    List<Reservation> getReservationsByListing(@Param("listing") Listing listing) throws InvalidListingIDException;


}

