package com.tp.wrc.findmyparadise.repositories;

import com.tp.wrc.findmyparadise.models.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarRepository extends JpaRepository<Calendar, Integer> {
}
