package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.repositories.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CalendarServiceImpl implements CalendarService{

    @Autowired
    private CalendarRepository cRepo;
}
