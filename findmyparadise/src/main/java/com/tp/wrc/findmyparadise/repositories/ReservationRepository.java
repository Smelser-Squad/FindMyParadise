package com.tp.wrc.findmyparadise.repositories;

import com.tp.wrc.findmyparadise.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    
}

