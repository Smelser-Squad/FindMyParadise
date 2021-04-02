package com.tp.wrc.findmyparadise.services;


import com.tp.wrc.findmyparadise.exceptions.*;

import com.tp.wrc.findmyparadise.models.Listing;
import com.tp.wrc.findmyparadise.models.Reservation;
import com.tp.wrc.findmyparadise.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImp implements ReservationService{

    @Autowired
    ReservationRepository repo;


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

        return repo.getReservationsByListing(listing);
    }


    @Override
    public Reservation addReservation(Reservation newReservation) throws NullReservationObjectException, NullGuestsException, InvalidGuestsException, NullDatesException, PastDatesException {
        if(newReservation==null){
            throw new NullReservationObjectException("Cannot add null reservation");

        }
        if(newReservation.getAdults() ==null|| newReservation.getChildren()==null || newReservation.getInfants()==null){
            throw new NullGuestsException("Cannot add reservation with null guests");
        }
        if(newReservation.getAdults()<1 || newReservation.getChildren()<0 || newReservation.getInfants()<0){
            throw new InvalidGuestsException("Cannot add reservation with invalid guests");
        }
        if(newReservation.getCheckInDate()==null || newReservation.getCheckOutDate()==null){
            throw new NullDatesException("Cannot add a reservation with null date");
        }

        if(newReservation.getCheckOutDate().isBefore(newReservation.getCheckInDate())){
            throw new PastDatesException("Cannot add reservation with past date");
        }



        return repo.saveAndFlush(newReservation);
    }

    @Override
    public Reservation updateReservation(Reservation newReservation) throws InvalidReservationIdException, NullReservationIdException, NullDatesException,InvalidGuestsException, NullGuestsException {
        Reservation edited = repo.findById(newReservation.getReservationId()).get();

        if(edited.getAdults() ==null|| edited.getChildren()==null || edited.getInfants()==null){
            throw new NullGuestsException("Cannot update reservation with null guests");
        }
        if(edited.getAdults()<1 || edited.getChildren()<0 || edited.getInfants()<0){
            throw new InvalidGuestsException("Cannot update reservation with invalid guests");
        }
        if(edited.getCheckInDate()==null || edited.getCheckOutDate()==null){
            throw new NullDatesException("Cannot update a reservation with null date");
        }

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

