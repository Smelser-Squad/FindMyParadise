package com.tp.wrc.findmyparadise.services;


import com.tp.wrc.findmyparadise.exceptions.InvalidReservationIdException;


import com.tp.wrc.findmyparadise.exceptions.NullReservationIdException;

import com.tp.wrc.findmyparadise.models.Reservation;

import java.util.List;

public interface ReservationService {
    List<Reservation> getAllReservations() throws InvalidReservationIdException, NullReservationIdException;
     Reservation getReservationById(Integer reservationId ) throws InvalidReservationIdException,NullReservationIdException;
    Reservation addReservation(Reservation newReservation) throws InvalidReservationIdException, NullReservationIdException;
    Reservation updateReservation(Reservation newReservation) throws InvalidReservationIdException, NullReservationIdException;
    boolean deleteReservation(Integer reservationId) throws InvalidReservationIdException, NullReservationIdException;
}
