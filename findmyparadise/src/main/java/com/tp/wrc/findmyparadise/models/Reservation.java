package com.tp.wrc.findmyparadise.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer reservationId;

    @Column
    private LocalDate checkInDate;

    @Column
    private LocalDate checkOutDate;

    @Column
    private Double price;

    @Column
    private Integer adults;

    @Column
    private Integer children;

    @Column
    private Integer infants;

    @OneToMany(mappedBy = "reservation", fetch = FetchType.LAZY)
    private Listing listing;
}
