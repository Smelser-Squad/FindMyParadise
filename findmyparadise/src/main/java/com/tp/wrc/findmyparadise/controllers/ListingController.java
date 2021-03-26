package com.tp.wrc.findmyparadise.controllers;

import com.tp.wrc.findmyparadise.exceptions.InvalidListingIDException;
import com.tp.wrc.findmyparadise.exceptions.NoListingFoundException;
import com.tp.wrc.findmyparadise.exceptions.NullListingIDException;
import com.tp.wrc.findmyparadise.models.Listing;
import com.tp.wrc.findmyparadise.services.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins ="http://localhost:8081")
public class ListingController {

    @Autowired
    ListingService service;

    @PostMapping("/listing")
    public ResponseEntity createListing(@RequestBody Listing newListing) {
        return ResponseEntity.ok(service.create(newListing));
    }

    @GetMapping("/listing/{listingId}")
    public ResponseEntity getListingByID(@PathVariable Integer listingId) {
        Listing toReturn = null;
        try {
            toReturn = service.show(listingId);
        } catch (NoListingFoundException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
        return ResponseEntity.ok(toReturn);
    }

    @GetMapping("/listings")
    public ResponseEntity getAllListings() {
        return ResponseEntity.ok(service.index());
    }

    @PutMapping("/updateListing/{listingID}")
    public ResponseEntity updateListing(@PathVariable Integer listingID, @RequestBody Listing updatedListing) {
        Listing toReturn = null;
        try {
            toReturn = service.update(listingID, updatedListing);
        } catch (NoListingFoundException | NullListingIDException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
        return ResponseEntity.ok(toReturn);
    }

    @DeleteMapping("/deleteListing/{listingID}")
    public ResponseEntity deleteListing(@PathVariable Integer listingID) {
        boolean status = false;
        try {
            status = service.destroy(listingID);
        } catch (NullListingIDException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
        if (status) {
            return ResponseEntity.ok("Listing successfully deleted");
        } else {
            return ResponseEntity.ok("Listing not deleted");
        }
    }
}
