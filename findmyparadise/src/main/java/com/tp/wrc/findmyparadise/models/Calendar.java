package com.tp.wrc.findmyparadise.models;

import java.time.LocalDate;
import java.util.Date;

public class Calendar {

    // Variables
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer numDays;


    //constructor
    public Calendar() {

    }



    //Getters and Setters
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getNumDays() {
        return numDays;
    }

    public void setNumDays(Integer numDays) {
        this.numDays = numDays;
    }


}