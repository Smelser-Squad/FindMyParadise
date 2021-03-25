package com.tp.wrc.findmyparadise.controllers;


import com.tp.wrc.findmyparadise.exceptions.InvalidEventIdException;
import com.tp.wrc.findmyparadise.exceptions.NullEventIdException;
import com.tp.wrc.findmyparadise.models.Event;
import com.tp.wrc.findmyparadise.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class EventController {
    @Autowired
    EventService service;

    //Adds a new event to the database by the given event model.
    @PostMapping("/event")
    public Event createEvent(@RequestBody Event event) {
        return service.create(event);
    }

    //Retrieves an event from the database by the given id.
    @GetMapping("/event/{id}")
    public Event getEventById(@PathVariable Integer id) throws InvalidEventIdException, NullEventIdException {
        return service.show(id);
    }

    //Retrieves a list of all Events in the database.
    @GetMapping("/events")
    public List<Event> getEvents() {
        return service.index();
    }

    //Edits an existing Event in the database by replacing its attributes with the
    //attributes of the given Event model.
    @PutMapping("/update/event")
    public Event editEvent(@RequestBody Event event) throws InvalidEventIdException {
        return service.update(event);
    }

    //Deletes an existing Event from the database.
    @DeleteMapping("/delete/event/{id}")
    public String deleteEvent(@PathVariable Integer id) throws NullEventIdException, InvalidEventIdException {
        if (service.destroy(id)) {
            return "Event " + id + " deleted";
        } else {
            return "Event " + id + " not found";
        }
    }

}
