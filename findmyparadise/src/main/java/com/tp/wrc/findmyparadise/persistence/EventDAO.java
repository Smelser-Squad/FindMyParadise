package com.tp.wrc.findmyparadise.persistence;


import com.tp.wrc.findmyparadise.exceptions.InvalidEventIdException;
import com.tp.wrc.findmyparadise.models.Event;

import java.util.List;

public interface EventDAO {

    Event getEventById(Integer id) throws InvalidEventIdException;

    List<Event> getEvents();

    Integer addEvent(Event event);

    boolean deleteEvent(Integer id) throws InvalidEventIdException;

    boolean editEvent(Integer id, Event event) throws InvalidEventIdException;



}
