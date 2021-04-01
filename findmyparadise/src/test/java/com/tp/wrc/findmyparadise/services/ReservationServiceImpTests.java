package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.exceptions.*;
import com.tp.wrc.findmyparadise.models.Reservation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ReservationServiceImpTests {

    @Autowired
    ReservationServiceImp toTest;



    @AfterEach
    public void tearDown() {

    }
    @Test
    public void addReservationGoldenPathTest(){
        try {
            Reservation newReservation = new Reservation();
            newReservation.setCheckInDate(LocalDate.now());
            newReservation.setCheckOutDate(LocalDate.of(2021, 4, 23));
            newReservation.setAdults(1);
            newReservation.setChildren(0);
            newReservation.setInfants(0);
            newReservation.setPrice(400.00);
            toTest.addReservation(newReservation);
            Reservation added = toTest.getReservationById(newReservation.getReservationId());

            assertEquals(LocalDate.now(), added.getCheckInDate());
            assertEquals(LocalDate.of(2021, 4, 23), added.getCheckOutDate());
            assertEquals(1, added.getAdults());
            assertEquals(0, added.getChildren());
            assertEquals(0, added.getInfants());
            assertEquals(400.00,added.getPrice());
        } catch (NullReservationIdException | InvalidReservationIdException | NullReservationObjectException | NullGuestsException | InvalidGuestsException | NullDatesException | PastDatesException ex)
        {
            fail();
        }
    }
    @Test
    public void addReserverationNullObjectTest(){
        assertThrows(NullReservationObjectException.class,()->toTest.addReservation(null));
    }

    @Test
    public void addReservationNullAdultTest(){
        Reservation reservation=new Reservation();
        reservation.setCheckInDate(LocalDate.now());
        reservation.setCheckOutDate(LocalDate.now());
        reservation.setAdults(null);
        reservation.setChildren(2);
        reservation.setInfants(1);

        assertThrows(NullGuestsException.class,()->toTest.addReservation(reservation));
    }
    @Test
    public void addReservationNullChildTest(){
        Reservation reservation=new Reservation();
        reservation.setCheckInDate(LocalDate.now());
        reservation.setCheckOutDate(LocalDate.now());
        reservation.setAdults(2);
        reservation.setChildren(null);
        reservation.setInfants(1);

        assertThrows(NullGuestsException.class,()->toTest.addReservation(reservation));
    }
    @Test
    public void addReservationNullInfantTest(){
        Reservation reservation=new Reservation();
        reservation.setCheckInDate(LocalDate.now());
        reservation.setCheckOutDate(LocalDate.now());
        reservation.setAdults(2);
        reservation.setChildren(1);
        reservation.setInfants(null);

        assertThrows(NullGuestsException.class,()->toTest.addReservation(reservation));
    }
    @Test
    public void addReservationAdultLowerBoundTest(){
        Reservation reservation=new Reservation();
        reservation.setCheckInDate(LocalDate.now());
        reservation.setCheckOutDate(LocalDate.now());
        reservation.setAdults(0);
        reservation.setChildren(1);
        reservation.setInfants(1);

        assertThrows(InvalidGuestsException.class,()->toTest.addReservation(reservation));
    }
    @Test
    public void addReservationChildLowerBoundTest(){
        Reservation reservation=new Reservation();
        reservation.setCheckInDate(LocalDate.now());
        reservation.setCheckOutDate(LocalDate.now());
        reservation.setAdults(1);
        reservation.setChildren(Integer.MIN_VALUE);
        reservation.setInfants(1);

        assertThrows(InvalidGuestsException.class,()->toTest.addReservation(reservation));
    }
    @Test
    public void addReservationInfantLowerBoundTest(){
        Reservation reservation=new Reservation();
        reservation.setCheckInDate(LocalDate.now());
        reservation.setCheckOutDate(LocalDate.now());
        reservation.setAdults(1);
        reservation.setChildren(1);
        reservation.setInfants(Integer.MIN_VALUE);

        assertThrows(InvalidGuestsException.class,()->toTest.addReservation(reservation));
    }
    @Test
    public void addReservationNullCheckInTest(){
        Reservation reservation=new Reservation();
        reservation.setCheckInDate(null);
        reservation.setCheckOutDate(LocalDate.now());
        reservation.setAdults(1);
        reservation.setChildren(0);
        reservation.setInfants(1);

        assertThrows(NullDatesException.class,()->toTest.addReservation(reservation));
    }
    @Test
    public void addReservationInvalidInfantTest(){
        Reservation reservation=new Reservation();
        reservation.setCheckInDate(LocalDate.now());
        reservation.setCheckOutDate(LocalDate.now());
        reservation.setAdults(1);
        reservation.setChildren(0);
        reservation.setInfants(Integer.MIN_VALUE);

        assertThrows(InvalidGuestsException.class,()->toTest.addReservation(reservation));
    }
    @Test
    public void addReservationCheckInDateLowerBound(){
        Reservation reservation=new Reservation();
        reservation.setCheckInDate(LocalDate.of(2020,8,6));
        reservation.setCheckOutDate(LocalDate.now());
        reservation.setAdults(1);
        reservation.setChildren(0);
        reservation.setInfants(0);

        assertThrows(PastDatesException.class,()->toTest.addReservation(reservation));
    }
    @Test
    public void addReservationCheckOutDateLowerBound(){
        Reservation reservation=new Reservation();
        reservation.setCheckInDate(LocalDate.now());
        reservation.setCheckOutDate(LocalDate.of(2020,5,13));
        reservation.setAdults(1);
        reservation.setChildren(0);
        reservation.setInfants(0);

        assertThrows(PastDatesException.class,()->toTest.addReservation(reservation));
    }
    @Test
    public void updateReservationGoldenPathTest() {
        try {
            Reservation reservation = toTest.getReservationById(1);

            reservation.setAdults(2);
            reservation.setChildren(2);
            toTest.updateReservation(reservation);

            assertEquals(1, reservation.getReservationId());
            assertEquals(2, reservation.getAdults());
            assertEquals(2, reservation.getChildren());

        } catch (NullReservationIdException | InvalidReservationIdException | NullDatesException | InvalidGuestsException | NullGuestsException ex) {
            fail();
        }
    }

    @Test
    public void deleteReservationGoldenPathTest() {
        try {
            Reservation test = toTest.getReservationById(1);

            toTest.deleteReservation(test.getReservationId());
        } catch (NullReservationIdException | InvalidReservationIdException  ex) {
            fail();
        }
    }
    @Test
    public void getReservationByIdGoldenPath() {
        try {
            Reservation reservation = toTest.getReservationById(1);

            assertEquals(1, reservation.getReservationId());
            assertEquals(2, reservation.getAdults());
            assertEquals(0, reservation.getChildren());
            assertEquals(400.00,reservation.getPrice());
            assertEquals(0,reservation.getInfants());
            assertEquals(LocalDate.now(),reservation.getCheckInDate());
            assertEquals(LocalDate.of(2021,4,23),reservation.getCheckOutDate());

        } catch (InvalidReservationIdException | NullReservationIdException ex) {
            fail();
        }
    }
    @Test
    public void getAllReservationsGoldenPathTest() throws NullReservationIdException, InvalidReservationIdException {
        List<Reservation> allreservations=toTest.getAllReservations();

        assertEquals(1,allreservations.size());
        assertEquals(1,allreservations.get(0).getReservationId());


    }
    @Test
    public void getReservationByNullIdTest(){
        assertThrows(NullReservationIdException.class,()->toTest.getReservationById(null));
    }
    @Test
    public void getReservationbyInvalidIdTest()
    {
        assertThrows(InvalidReservationIdException.class,()->toTest.getReservationById(Integer.MIN_VALUE));
    }
    @Test
    public void deleteReservationNullIdTest(){
        assertThrows(NullReservationIdException.class,()->toTest.deleteReservation(null));
    }

}
