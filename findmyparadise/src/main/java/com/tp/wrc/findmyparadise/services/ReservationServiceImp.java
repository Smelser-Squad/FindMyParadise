package com.tp.wrc.findmyparadise.services;


import com.tp.wrc.findmyparadise.exceptions.InvalidListingIDException;
import com.tp.wrc.findmyparadise.exceptions.InvalidReservationIdException;

import com.tp.wrc.findmyparadise.exceptions.NullReservationIdException;

import com.tp.wrc.findmyparadise.models.Listing;
import com.tp.wrc.findmyparadise.models.Reservation;
import com.tp.wrc.findmyparadise.repositories.ListingRepository;
import com.tp.wrc.findmyparadise.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImp implements ReservationService{

    @Autowired
    ReservationRepository repo;

    @Autowired
    ListingRepository lrepo;
    @Override
    public List<Reservation> getAllReservations() throws InvalidReservationIdException, NullReservationIdException {
        return repo.findAll();
    }

    @Override
    public Reservation getReservationById(Integer reservationId) throws InvalidReservationIdException, NullReservationIdException {
        if(reservationId==null){
            throw new NullReservationIdException("Null Reservation id entered");
        }
        Reservation newReservation = null;
        Optional<Reservation> reservation = repo.findById(reservationId);
        if (reservation.isPresent()) {
            newReservation = reservation.get();

            return newReservation;
        } else {
            throw new InvalidReservationIdException("a Reservation with that ID doesn't exist");
        }
    }

    @Override
    public List<Reservation> getReservationsByListing(Listing listing) throws InvalidListingIDException {
        Optional<Listing> retrieved=lrepo.findById(listing.getListingID());
        if(retrieved.isEmpty()){
            throw  new InvalidListingIDException("No listing found for reservation");
        }
        return repo.getReservationsByListing(listing);
    }


    @Override
    public Reservation addReservation(Reservation newReservation) throws InvalidReservationIdException, NullReservationIdException {
        return repo.saveAndFlush(newReservation);
    }

    @Override
    public Reservation updateReservation(Reservation newReservation) throws InvalidReservationIdException, NullReservationIdException {
        Reservation edited = repo.findById(newReservation.getReservationId()).get();

        if (edited != null) {

            edited.setListing(newReservation.getListing());
            edited.setPrice(newReservation.getPrice());;
            edited.setCheckInDate(newReservation.getCheckInDate());
            edited.setCheckOutDate(newReservation.getCheckOutDate());
            edited.setAdults(newReservation.getAdults());
            edited.setChildren(newReservation.getChildren());
            edited.setInfants(newReservation.getInfants());

            return repo.saveAndFlush(edited);
        } else {
            throw new InvalidReservationIdException("Reservation with that ID doesn't exist");
        }

    }

    @Override
    public boolean deleteReservation(Integer reservationId) throws InvalidReservationIdException, NullReservationIdException {
        if(reservationId==null){
            throw new NullReservationIdException("Null Reservation id entered");
        }
        Reservation newReservation = repo.findById(reservationId).get();

        if (newReservation != null) {
            repo.delete(newReservation);
            return true;
        } else {
            throw new InvalidReservationIdException("a Reservation with that ID doesn't exist");
        }
    }
    }

