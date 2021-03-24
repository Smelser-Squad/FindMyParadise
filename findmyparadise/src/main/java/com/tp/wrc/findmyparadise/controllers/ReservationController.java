package com.tp.wrc.findmyparadise.controllers;

import com.tp.wrc.findmyparadise.models.Reservation;
import com.tp.wrc.findmyparadise.persistence.ReservationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ReservationController {
    @Autowired
    ReservationDAO repo;

    @GetMapping("/reservations")
    public List<Reservation> getAllReservations(){
        return repo.findAll();

    }
    @GetMapping("/reservation/{reservationId}")
    public Reservation getReservation(@PathVariable Integer reservationId) {
        Optional<Reservation> reservation = repo.findById(reservationId);

        if (reservation.isPresent()) {
            return reservation.get();
        }
        return new Reservation();
    }
    @PostMapping("/reserve")
    public void addResveration(@RequestBody Reservation newReservation){
        Reservation added=repo.save(newReservation);

    }
    @PutMapping("/update/reservation")
    public Reservation updateReservation(@RequestBody Reservation updatereservation) {
        Optional<Reservation> found = repo.findById(updatereservation.getReservationId());

        if (found.isPresent()) {
            return repo.save(updatereservation);
        }
        return updatereservation;
    }
    @DeleteMapping("/delete/reservation/{reservationId}")
    public void deleteReservation(@PathVariable Integer reservationId){
        Optional<Reservation> found = repo.findById(reservationId);

        if (found.isPresent()) {
            repo.deleteById(reservationId);

        }
    }
}
