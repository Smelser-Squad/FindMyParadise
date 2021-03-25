package com.tp.wrc.findmyparadise.controllers;
import com.tp.wrc.findmyparadise.exceptions.InvalidHostIDException;
import com.tp.wrc.findmyparadise.exceptions.NullHostIDException;
import com.tp.wrc.findmyparadise.services.PhotoGalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PhotoGalleryController {

    @Autowired
    PhotoGalleryService service;

    @GetMapping("/getById/{id}")
    public ResponseEntity getById(@PathVariable Integer id)
    {
        try {
            return ResponseEntity.ok(service.getById(id));
        }
        catch (Exception ex)
        {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/getByListing/{listingId}")
    public ResponseEntity getByListingId(@PathVariable Integer listingId)
    {
        try {
            return ResponseEntity.ok(service.getByListing(listingId));
        }
        catch (Exception ex)
        {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/getByListingAndCategory/{listingId}/{categoryId}")
    public ResponseEntity getHostByID(@PathVariable Integer listingId, Integer categoryId)
    {
        try {
            return ResponseEntity.ok(service.getbyListingAndCategory(listingId, categoryId));
        }
        catch (Exception ex)
        {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    


}
