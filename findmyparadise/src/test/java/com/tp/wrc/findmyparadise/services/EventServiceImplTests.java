package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.models.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class EventServiceImplTests {

    @Autowired
    EventServiceImpl toTest;


    //this will run before each @Test method
    @BeforeEach
    public void setup() {
        Event event = new Event();
        event.setTitle("Event Title");
        event.setCategory("Event Category");
        event.setSummary("Event Summary");
        event.setCost(0);
        event.setLatitude(0);
        event.setLongitude(0);

    }

    @Test //Testing retrieving an event by ID.
    public void findEventByIdTest() {
        Event event = toTest.show(1);
        assertEquals("Event Title", event.getTitle());
        assertEquals("Event Category", event.getCategory());
        assertEquals("Event Summary", event.getSummary());
        assertEquals(0, event.getCost());
        assertEquals(0, event.getLatitude());
        assertEquals(0, event.getLongitude());

    }

    @Test //Testing retrieving all events.
    public void findAllEventsTest() {
        List<Event> events = toTest.index();
        assertEquals("Event Title", events.get(0).getTitle());
        assertEquals("Event Category", events.get(0).getCategory());
        assertEquals("Event Summary", events.get(0).getSummary());
        assertEquals(0, events.get(0).getCost());
        assertEquals(0, events.get(0).getLatitude());
        assertEquals(0, events.get(0).getLongitude());

    }

    @Test //Testing creating an event.
    public void createEventTest() {
        Event event = new Event();
        event.setTitle("Event Title #2");
        event.setCategory("Event Category #2");
        event.setSummary("Event Summary #2");
        event.setCost(0);
        event.setLatitude(0);
        event.setLongitude(0);

        event = toTest.create(event);
        assertEquals(2, event.getId());
        assertEquals("Event Title #2", event.getTitle());
        assertEquals("Event Category #2", event.getCategory());
        assertEquals("Event Summary #2", event.getSummary());
        assertEquals(0, event.getCost());
        assertEquals(0, event.getLatitude());
        assertEquals(0, event.getLongitude());


    }




}
