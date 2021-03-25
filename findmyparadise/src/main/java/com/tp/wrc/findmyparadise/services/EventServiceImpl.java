package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.models.Event;
import com.tp.wrc.findmyparadise.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eRepo;


    @Override
    public List<Event> index() {
        return eRepo.findAll();
    }

    @Override
    public Event show(int id) {
        Event event = null;
        Optional<Event> opt = eRepo.findById(id);
        if (opt.isPresent()) {
            event = opt.get();

            return event;
        }
        return null;
    }

    @Override
    public List<Event> findAllByCategory(String category) {
        List<Event> events = eRepo.findAllByCategory(category);

       return events;
    }

    @Override
    public Event create(Event event) {
        return eRepo.saveAndFlush(event);
    }

    @Override
    public Event update(Event event) {

        Event eventToUpdate = eRepo.findById(event.getId()).get();

        if (eventToUpdate != null) {

            eventToUpdate.setTitle(event.getTitle());
            eventToUpdate.setSummary(event.getSummary());
            eventToUpdate.setCategory(event.getCategory());
            eventToUpdate.setCost(event.getCost());
            eventToUpdate.setLatitude(event.getLatitude());
            eventToUpdate.setLongitude(event.getLongitude());

            return eRepo.saveAndFlush(eventToUpdate);
        }

        return null;
    }

    @Override
    public boolean destroy(int id) {

        Event event = eRepo.findById(id).get();

        if (event != null) {
            eRepo.delete(event);
            return true;
        }

        return false;
    }
}
