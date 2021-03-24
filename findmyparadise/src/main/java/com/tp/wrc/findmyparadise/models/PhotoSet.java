package com.tp.wrc.findmyparadise.models;


import javax.persistence.*;

@Entity
@Table(name = "photoset")
public class PhotoSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //Primary Key, Cannot be null
    private String[] setLinks;
    private String Category;
    private Integer listingID;


}
