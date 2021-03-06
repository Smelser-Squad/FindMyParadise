package com.tp.wrc.findmyparadise.services;


import com.tp.wrc.findmyparadise.exceptions.*;


import com.tp.wrc.findmyparadise.models.Listing;
import com.tp.wrc.findmyparadise.models.Reservation;

import java.util.List;

public interface ReservationService {
    List<Reservation> getAllReservations() throws InvalidReservationIdException, NullReservationIdException;
    Reservation getReservationById(Integer reservationId ) throws InvalidReservationIdException,NullReservationIdException;
    List<Reservation> getReservationsByListing(Listing listing) throws InvalidListingIDException;
    Reservation addReservation(Reservation newReservation, Integer listingId) throws NullReservationObjectException, NullGuestsException, InvalidGuestsException, NullDatesException, PastDatesException, NoListingFoundException;
    Reservation updateReservation(Reservation newReservation, Integer listing) throws InvalidReservationIdException, NullReservationIdException, InvalidGuestsException, NullDatesException, NullGuestsException, NoListingFoundException;
    boolean deleteReservation(Integer reservationId) throws InvalidReservationIdException, NullReservationIdException;
}
