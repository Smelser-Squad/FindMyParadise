package com.tp.wrc.findmyparadise.services;


import com.tp.wrc.findmyparadise.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventService {

    public List<Event> index();

    public Event show(int id);

    public Event create(Event event);

    public Event update(Event event, int id);

    public boolean destroy(int id);
}
