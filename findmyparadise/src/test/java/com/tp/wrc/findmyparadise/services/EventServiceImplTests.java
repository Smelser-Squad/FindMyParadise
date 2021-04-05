package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.models.Event;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EventServiceImplTests {

    @Autowired
    EventServiceImpl toTest;

    @BeforeEach
    public void setUp() {

        Event event = new Event();
        event.setTitle("Event Title");
        event.setCategory("Event Category");
        event.setSummary("Event Summary");
        event.setCost(0);
        event.setLatitude(0);
        event.setLongitude(0);
        toTest.create(event);

    }

    @AfterEach
    public void tearDown() {

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

    @Test
    public void findAllEventsTest() {
        List<Event> events = toTest.index();
        assertEquals("Event Title", events.get(0).getTitle());
        assertEquals("Event Category", events.get(0).getCategory());
        assertEquals("Event Summary", events.get(0).getSummary());
        assertEquals(0, events.get(0).getCost());
        assertEquals(0, events.get(0).getLatitude());
        assertEquals(0, events.get(0).getLongitude());

    }

    @Test
    public void createEventTest() {
        Event newEvent = new Event();
        newEvent.setTitle("Event Title #2");
        newEvent.setCategory("Event Category #2");
        newEvent.setSummary("Event Summary #2");
        newEvent.setCost(0);
        newEvent.setLatitude(0);
        newEvent.setLongitude(0);

        newEvent = toTest.create(newEvent);
        Event event = toTest.show(newEvent.getId());

        assertEquals("Event Title #2", event.getTitle());
        assertEquals("Event Category #2", event.getCategory());
        assertEquals("Event Summary #2", event.getSummary());
        assertEquals(0, event.getCost());
        assertEquals(0, event.getLatitude());
        assertEquals(0, event.getLongitude());

    }

    @Test
    public void updateEventTest() {
        Event updatedEvent = new Event("Updated Event Title", "Updated Event Summary", "Updated Event Category", "Updated Image Source", 1, 1, 1, 1);
        updatedEvent.setId(1);
        toTest.update(updatedEvent);
        Event event = toTest.show(1);
        assertNotNull(event);
        assertEquals("Updated Event Title", event.getTitle());
    }

    @Test
    public void destroyEventTest() {
        assertTrue(toTest.destroy(1));
    }

    @Test
    public void destroyEventWithNullIdTest() {
        assertFalse(toTest.destroy(Integer.MAX_VALUE));
    }

}
