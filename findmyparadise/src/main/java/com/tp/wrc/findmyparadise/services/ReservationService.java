package com.tp.wrc.findmyparadise.services;


import com.tp.wrc.findmyparadise.exceptions.*;


import com.tp.wrc.findmyparadise.models.Listing;
import com.tp.wrc.findmyparadise.models.Reservation;

import java.util.List;

public interface ReservationService {
    List<Reservation> getAllReservations() throws InvalidReservationIdException, NullReservationIdException;
     Reservation getReservationById(Integer reservationId ) throws InvalidReservationIdException,NullReservationIdException;
    List<Reservation> getReservationsByListing(Listing listing) throws InvalidListingIDException;
    Reservation addReservation(Reservation newReservation) throws NullReservationObjectException, NullGuestsException, InvalidGuestsException, NullDatesException, PastDatesException;
    Reservation updateReservation(Reservation newReservation) throws InvalidReservationIdException, NullReservationIdException, InvalidGuestsException,NullDatesException, NullGuestsException;
    boolean deleteReservation(Integer reservationId) throws InvalidReservationIdException, NullReservationIdException;
}
