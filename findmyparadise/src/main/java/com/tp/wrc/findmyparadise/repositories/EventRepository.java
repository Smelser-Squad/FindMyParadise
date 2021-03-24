package com.tp.wrc.findmyparadise.repositories;


import com.tp.wrc.findmyparadise.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {

    public Event findByCategory(String category);

}
