package com.tp.wrc.findmyparadise.controllers;

import com.tp.wrc.findmyparadise.exceptions.InvalidListingIDException;
import com.tp.wrc.findmyparadise.exceptions.NullListingIDException;
import com.tp.wrc.findmyparadise.models.Listing;
import com.tp.wrc.findmyparadise.services.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ListingController {

    @Autowired
    ListingService service;

    @PostMapping("/listing/")
    public ResponseEntity createListing(@RequestBody Listing newListing) {
        try {
            return ResponseEntity.ok(service.create(newListing));
        } catch (NullListingIDException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/listing/{listingID}")
    public ResponseEntity getListingByID(@PathVariable Integer listingID) {
        Listing toReturn = null;

        return null;
    }
}
