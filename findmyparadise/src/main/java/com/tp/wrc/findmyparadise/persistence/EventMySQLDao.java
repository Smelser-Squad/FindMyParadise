package com.tp.wrc.findmyparadise.persistence;

import com.tp.wrc.findmyparadise.exceptions.InvalidEventIdException;
import com.tp.wrc.findmyparadise.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventMySQLDao implements EventDAO {


    @Autowired
    private JdbcTemplate template;


    @Override
    public Event getEventById(Integer id) throws InvalidEventIdException {
        return null;
    }

    @Override
    public List<Event> getEvents() {
        return null;
    }

    @Override
    public Integer addEvent(Event event) {
        return null;
    }

    @Override
    public boolean deleteEvent(Integer id) throws InvalidEventIdException {
        return false;
    }

    @Override
    public boolean editEvent(Integer id, Event event) throws InvalidEventIdException {
        return false;
    }
}
