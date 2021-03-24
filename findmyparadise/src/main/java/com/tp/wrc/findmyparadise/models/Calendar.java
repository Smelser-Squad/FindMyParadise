package com.tp.wrc.findmyparadise.models;

<<<<<<< HEAD
import javax.persistence.Entity;
=======
import javax.persistence.*;
>>>>>>> 8ddd09673c0c32e96326f656b7952ba91bfb9149
import java.time.LocalDate;
import java.util.Date;

@Entity
<<<<<<< HEAD
=======
@Table(name = "calendar")
>>>>>>> 8ddd09673c0c32e96326f656b7952ba91bfb9149
public class Calendar {

    // Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //Primary Key, Cannot be null

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
