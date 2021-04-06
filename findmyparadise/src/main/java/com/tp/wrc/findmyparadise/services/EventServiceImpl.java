package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.exceptions.NoListingFoundException;
import com.tp.wrc.findmyparadise.models.Event;
import com.tp.wrc.findmyparadise.models.Listing;
import com.tp.wrc.findmyparadise.repositories.EventRepository;
import com.tp.wrc.findmyparadise.repositories.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eRepo;

    @Autowired
    private ListingRepository lRepo;


    @Override
    public List<Event> index() {
        return eRepo.findAll();
    }

    @Override
    public List<Event> indexWithinDistance(Integer listingId, int distance) throws NoListingFoundException {
        List<Event> events = eRepo.findAll();
        List<Event> toReturn = new ArrayList();
        Listing listing = lRepo.findById(listingId).get();

        for (Event event : events) {
            double theta = listing.getLongitude() - event.getLongitude();
            double dist = Math.sin(deg2rad(listing.getLatitude())) * Math.sin(deg2rad(event.getLatitude())) + Math.cos(deg2rad(listing.getLatitude())) * Math.cos(deg2rad(event.getLatitude())) * Math.cos(deg2rad(theta));
            dist = Math.acos(dist);
            dist = rad2deg(dist);
            dist = dist * 60 * 1.1515;
            dist = ((int)(dist * 100))/100;
            event.setDistance(dist);
            if (dist <= distance) {
                toReturn.add(event);
            }
        }


        return toReturn;


    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    /*::  This function converts decimal degrees to radians             :*/
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    /*::  This function converts radians to decimal degrees             :*/
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
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
    public List<Event> findByCategory(String category) {
        List<Event> events = eRepo.findByCategory(category);

        return events;
    }

    @Override
    public Event create(Event event) {
        return eRepo.saveAndFlush(event);
    }

    @Override
    public Event update(Event updatedEvent) {

        if (updatedEvent != null) {
            Event event = null;
            Optional<Event> opt = eRepo.findById(updatedEvent.getId());
            if (opt.isPresent()) {
                event = opt.get();

                event.setTitle(updatedEvent.getTitle());
                event.setSummary(updatedEvent.getSummary());
                event.setCategory(updatedEvent.getCategory());
                event.setCost(updatedEvent.getCost());
                event.setLatitude(updatedEvent.getLatitude());
                event.setLongitude(updatedEvent.getLongitude());

                return eRepo.saveAndFlush(event);
            }
        }
        return null;
    }

    @Override
    public boolean destroy(int id) {
        Event event = null;
        Optional<Event> opt = eRepo.findById(id);
        if (opt.isPresent()) {
            event = opt.get();
            eRepo.delete(event);
            return true;
        }
        return false;
    }
}