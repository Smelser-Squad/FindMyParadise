package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.exceptions.InvalidReservationIdException;
import com.tp.wrc.findmyparadise.exceptions.NullReservationIdException;
import com.tp.wrc.findmyparadise.models.Listing;
import com.tp.wrc.findmyparadise.models.Reservation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ReservationImpTests {

    @Autowired
    ReservationServiceImp toTest;

    @BeforeEach
    public void setup() {
        Reservation reservation = new Reservation();
        Listing listing = new Listing();
        reservation.setCheckInDate(LocalDate.now());
        reservation.setCheckOutDate(LocalDate.of(2021, 4, 13));
        reservation.setAdults(1);
        reservation.setChildren(0);
        reservation.setInfants(0);
        listing.setName("Tamera");
        listing.setDescription("Clean");
        listing.setAddress("10 Water Street");
        listing.setPrice(100.00);
        reservation.setPrice(listing.getPrice() * (ChronoUnit.DAYS.between(reservation.getCheckInDate(), reservation.getCheckOutDate())));
        reservation.setListing(listing);
    }

    @AfterEach
    public void tearDown() {

    }
    @Test
    public void getReservationByIdGoldenPath() {
        try {
            Reservation test = toTest.getReservationById(1);
            assertEquals(LocalDate.now(),test.getCheckInDate());
            assertEquals(LocalDate.of(2021,4,13),test.getCheckOutDate());
            assertEquals(1,test.getAdults());
            assertEquals(0,test.getChildren());
            assertEquals(0,test.getInfants());
            assertEquals(23.00,test.getPrice());
        } catch (InvalidReservationIdException | NullReservationIdException ex) {


        }
    }
        @Test
    public void deleteReservationTest() {

        assertThrows(InvalidReservationIdException.class,()->toTest.deleteReservation(1));


        }

    @Test
    public void deleteReservationWithNullIdTest() {
        assertThrows(NullReservationIdException.class, () -> toTest.deleteReservation(null));
    }


}
