package com.tp.wrc.findmyparadise.services;


import com.tp.wrc.findmyparadise.persistence.CalendarMySQLDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
<<<<<<< HEAD
public interface CalendarService {




=======
public class CalendarService {

    @Autowired
    CalendarMySQLDao dao;

    
>>>>>>> 50c3bb1645f1f7e5d7510b6a4ae96deaf62fa602
}
