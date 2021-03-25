package com.tp.wrc.findmyparadise.controllers;

import com.tp.wrc.findmyparadise.models.Amenity;
import com.tp.wrc.findmyparadise.services.AmenityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AmenityController {

    @Autowired
    AmenityServiceImpl service;

    @PostMapping("/new/amenity")
    public ResponseEntity createAmenity(@RequestBody Amenity amenity) {
        Amenity toReturn;
        try {
            toReturn = service.create(amenity);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        return ResponseEntity.ok(toReturn);
    }

    @GetMapping("/amenities")
    public ResponseEntity getAllAmenities() {
        List<Amenity> toReturn;

        try {
            toReturn = service.getAllAmenities();
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        return ResponseEntity.ok(toReturn);
    }

    @GetMapping("/amenities/id/{amenityId}")
    public ResponseEntity getAmenityById(@PathVariable Integer amenityId) {
        Amenity toReturn;
        try {
            toReturn = service.getAmenityById(amenityId);
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        return ResponseEntity.ok(toReturn);
    }

    @PutMapping("/update/amenity")
    public ResponseEntity updateAmenity(@RequestBody Amenity amenity) {
        try {
            service.update(amenity);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        return ResponseEntity.ok(amenity);
    }

    @DeleteMapping("/delete/amenity/{id}")
    public String deleteAmenity(@PathVariable Integer id) {
        try {
            if(service.destroy(id))
                return "Amenity " + id + " successfully deleted.";
            else
                return "Amenity " + id + " does not exist.";
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }

}