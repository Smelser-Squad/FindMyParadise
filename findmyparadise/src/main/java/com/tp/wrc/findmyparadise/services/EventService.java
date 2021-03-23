package com.tp.wrc.findmyparadise.services;


import com.tp.wrc.findmyparadise.exceptions.InvalidEventIdException;
import com.tp.wrc.findmyparadise.exceptions.NullEventIdException;
import com.tp.wrc.findmyparadise.models.Event;
import com.tp.wrc.findmyparadise.persistence.EventMySQLDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    EventMySQLDao dao;

    public Integer addEvent(Event event) {
        return dao.addEvent(event);
    }

    public Event getEventById(Integer id) throws NullEventIdException, InvalidEventIdException {
        if (id == null) {
            throw new NullEventIdException("You cannot retrieve an Event with null id.");
        }

        Event event = dao.getEventById(id);
        if (event == null) {
            throw new InvalidEventIdException("No Event with that ID exists.");
        } else {
            return event;
        }

    }

    //Retrieves a list of all existing Events in the database.
    public List<Event> getEvents() {
        return dao.getEvents();
    }

    public boolean editEvent(Integer id, Event event) throws InvalidEventIdException {
        return dao.editEvent(id, event);
    }

    //Deletes an existing Event from the database.
    //An exception will be thrown if given a null for the id to check for when deleting.
    public boolean deleteEvent(Integer id) throws NullEventIdException, InvalidEventIdException {
        if (id == null) {
            throw new NullEventIdException("You cannot delete an Event with null id.");
        }
        return dao.deleteEvent(id);
    }

}
