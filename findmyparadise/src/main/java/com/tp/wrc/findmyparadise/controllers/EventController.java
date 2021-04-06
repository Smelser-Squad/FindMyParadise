package com.tp.wrc.findmyparadise.controllers;


import com.tp.wrc.findmyparadise.exceptions.InvalidEventIdException;
import com.tp.wrc.findmyparadise.exceptions.NullEventIdException;
import com.tp.wrc.findmyparadise.models.Amenity;
import com.tp.wrc.findmyparadise.models.Event;
import com.tp.wrc.findmyparadise.models.Listing;
import com.tp.wrc.findmyparadise.services.EventService;
import com.tp.wrc.findmyparadise.services.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins ="http://localhost:8081")
public class EventController {
    @Autowired
    EventService service;
    ListingService lService;

    //Adds a new event to the database by the given event model.

    @PostMapping("/event")
    public ResponseEntity createEvent(@RequestBody Event event) {

        Event toReturn;
        try {
            toReturn = service.create(event);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        return ResponseEntity.ok(toReturn);
    }

    //Retrieves an event from the database by the given id.
    @GetMapping("/event/{eventId}")
    public ResponseEntity getEventById(@PathVariable Integer eventId) throws InvalidEventIdException, NullEventIdException {
        Event toReturn;
        try {
            toReturn = service.show(eventId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        return ResponseEntity.ok(toReturn);

    }

    //Retrieves a list of all Events in the database.
    @GetMapping("/events")
    public ResponseEntity getEvents() {

        List<Event> toReturn;
        try {
            toReturn = service.index();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        return ResponseEntity.ok(toReturn);
    }

    //Retrieves a list of all Events in the database within a given distance (in miles) from a Listing.
    @GetMapping("/events/{listingId}/{distance}")
    public ResponseEntity getEventsWithinDistance(@PathVariable Integer listingId, @PathVariable int distance) {

        List<Event> toReturn;
        try {
            toReturn = service.indexWithinDistance(listingId, distance);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        return ResponseEntity.ok(toReturn);
    }

    //Retrieves a list of events by the given category
//    @GetMapping("/events/{category}")
//    public ResponseEntity findEventsByCategory(@PathVariable String category) {
//        List<Event> toReturn;
//        try {
//            toReturn = service.findByCategory(category);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//        }
//
//        return ResponseEntity.ok(toReturn);
//    }

    //Edits an existing Event in the database by replacing its attributes with the
    //attributes of the given Event model.
    @PutMapping("/event")
    public ResponseEntity updateEvent(@RequestBody Event event) throws InvalidEventIdException {
        try {
            service.update(event);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        return ResponseEntity.ok(event);
    }

    //Deletes an existing Event from the database.
    @DeleteMapping("/deleteEvent/{eventId}")
    public String deleteEvent(@PathVariable Integer eventId) throws NullEventIdException, InvalidEventIdException {
        try {
            if (eventId == null)
                return "Event not deleted. Null passed for ID.";
            if (service.destroy(eventId))
                return "Event " + eventId + " successfully deleted.";
            else
                return "Event " + eventId + " does not exist.";
        } catch (Exception e) {
            return e.getMessage();
        }

    }

}
