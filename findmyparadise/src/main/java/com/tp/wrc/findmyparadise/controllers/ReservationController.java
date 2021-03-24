package com.tp.wrc.findmyparadise.controllers;

import com.tp.wrc.findmyparadise.models.Reservation;
import com.tp.wrc.findmyparadise.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ReservationController {
    @Autowired
    ReservationRepository service;

    @GetMapping("/reservations")
    public List<Reservation> getAllReservations(){
        return service.findAll();

    }
    @GetMapping("/reservation/{reservationId}")
    public Reservation getReservation(@PathVariable Integer reservationId) {
        Optional<Reservation> reservation = service.findById(reservationId);

        if (reservation.isPresent()) {
            return reservation.get();
        }
        return new Reservation();
    }
    @PostMapping("/reserve")
    public Reservation addResveration(@RequestBody Reservation newReservation) {
        Reservation added = service.save(newReservation);
        return added;
    }
    @PutMapping("/update/reservation")
    public Reservation updateReservation(@RequestBody Reservation updatereservation) {
        Optional<Reservation> found = service.findById(updatereservation.getReservationId());

        if (found.isPresent()) {
            return service.save(updatereservation);
        }
        return updatereservation;
    }
    @DeleteMapping("/delete/reservation/{reservationId}")
    public String deleteReservation(@PathVariable Integer reservationId){
        Optional<Reservation> found = service.findById(reservationId);

        if (found.isPresent()) {
            service.deleteById(reservationId);
            return "Reservation " + reservationId + " deleted";
        } else {
            return "Reservation " + reservationId + " not found";
        }
        }

}
