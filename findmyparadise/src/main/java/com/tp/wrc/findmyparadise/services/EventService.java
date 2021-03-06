package com.tp.wrc.findmyparadise.services;


import com.tp.wrc.findmyparadise.exceptions.NoListingFoundException;
import com.tp.wrc.findmyparadise.models.Event;
import com.tp.wrc.findmyparadise.models.Listing;

import java.util.List;

public interface EventService {

    public List<Event> index();

    public List<Event> indexWithinDistance(Integer listingId, int distance) throws NoListingFoundException;

    public Event show(int id);

    public List<Event> findByCategory(String category);

    public Event create(Event event);

    public Event update(Event event);

    public boolean destroy(int id);
}
