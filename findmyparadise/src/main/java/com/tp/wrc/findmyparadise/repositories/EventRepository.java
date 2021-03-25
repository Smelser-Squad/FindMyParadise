package com.tp.wrc.findmyparadise.repositories;


import com.tp.wrc.findmyparadise.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

    public List<Event> findAllByCategory(String category);

}
