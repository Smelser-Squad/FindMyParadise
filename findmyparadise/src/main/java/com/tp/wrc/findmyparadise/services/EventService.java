package com.tp.wrc.findmyparadise.services;


import com.tp.wrc.findmyparadise.models.Event;

import java.util.List;

public interface EventService {

    public List<Event> index();

    public Event show(int id);

    public List<Event> findAllByCategory(String category);

    public Event create(Event event);

    public Event update(Event event, Integer id);

    public boolean destroy(int id);
}
