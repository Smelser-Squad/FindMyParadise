package com.tp.wrc.findmyparadise.controllers;

import com.tp.wrc.findmyparadise.exceptions.InvalidHostIDException;
import com.tp.wrc.findmyparadise.exceptions.InvalidReservationIdException;
import com.tp.wrc.findmyparadise.exceptions.NullHostIDException;
import com.tp.wrc.findmyparadise.exceptions.NullReservationIdException;
import com.tp.wrc.findmyparadise.models.Reservation;
import com.tp.wrc.findmyparadise.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins ="http://localhost:8081")
public class ReservationController {

    @Autowired
    ReservationService service;

    @GetMapping("/reservations")
    public ResponseEntity getAllReservations() {
        try {
            return ResponseEntity.ok(service.getAllReservations());
        } catch (NullReservationIdException | InvalidReservationIdException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

    }

    @GetMapping("/reservation/{reservationId}")
    public ResponseEntity getReservation(@PathVariable Integer reservationId) {
        try {
            return ResponseEntity.ok(service.getReservationById(reservationId));
        } catch (NullReservationIdException | InvalidReservationIdException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/reservation")
    public ResponseEntity addReservation(@RequestBody Reservation newReservation) {
        try {
            return ResponseEntity.ok(service.addReservation(newReservation));
        } catch (NullReservationIdException | InvalidReservationIdException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping("/update/reservation")
    public ResponseEntity updateReservation(@RequestBody Reservation newReservation) {
        try {
            return ResponseEntity.ok(service.updateReservation(newReservation));

        } catch (NullReservationIdException | InvalidReservationIdException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/delete/reservation/{reservationId}")
    public String deleteReservation(@PathVariable Integer reservationId) {
        {
            String toReturn = "";

            try {
                if (service.deleteReservation(reservationId)) {
                    toReturn = "Event " + reservationId + " deleted";
                } else {
                    toReturn = "Event " + reservationId + " not found";
                }
            } catch (InvalidReservationIdException | NullReservationIdException ex) {
                ex.getMessage();
            }

            return toReturn;
        }

    }
}
