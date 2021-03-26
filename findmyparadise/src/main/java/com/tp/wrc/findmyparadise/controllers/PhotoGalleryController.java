package com.tp.wrc.findmyparadise.controllers;
import com.tp.wrc.findmyparadise.models.Photo;
import com.tp.wrc.findmyparadise.services.PhotoGalleryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PhotoGalleryController {

    @Autowired
    PhotoGalleryServiceImpl service;

    @GetMapping("/gallery/{id}")
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

    @GetMapping("/gallery/listing/{listingId}")
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


    //may not be necessary
//    @GetMapping("/gallery/listing/{listingId}/category/{categoryId}")
//    public ResponseEntity getByIds(@PathVariable Integer listingId, Integer categoryId)
//    {
//        try {
//            return ResponseEntity.ok(service.getByListingAndCategory(listingId, categoryId));
//        }
//        catch (Exception ex)
//        {
//            return ResponseEntity.badRequest().body(ex.getMessage());
//        }
//    }

    @PostMapping("/gallery/addImage")
    public ResponseEntity AddImage(@RequestBody Photo toAdd)
    {
        try{
            return ResponseEntity.ok(service.addImage(toAdd));
        }
        catch(Exception ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/gallery/delete/{id}")
    public String deleteById(@PathVariable Integer imageId)
    {
        String toReturn = "";

        try {
            if (service.delete(imageId)) {
                toReturn = "Event " + imageId + " deleted";
            } else {
                toReturn = "Event " + imageId + " not found";
            }
        }
        catch (Exception ex)
        {
            ex.getMessage();
        }

        return toReturn;
    }

    


}
