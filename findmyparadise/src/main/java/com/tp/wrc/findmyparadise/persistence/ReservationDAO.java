package com.tp.wrc.findmyparadise.persistence;

import com.tp.wrc.findmyparadise.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationDAO extends JpaRepository<Reservation, Integer> {
}
