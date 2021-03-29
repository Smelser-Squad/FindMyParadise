package com.tp.wrc.findmyparadise.controllers;

import com.tp.wrc.findmyparadise.exceptions.InvalidReviewerIdException;
import com.tp.wrc.findmyparadise.exceptions.NullReviewerIdException;
import com.tp.wrc.findmyparadise.models.Reviewer;
import com.tp.wrc.findmyparadise.services.ReviewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")


@CrossOrigin(origins ="http://localhost:8081")
public class ReviewerController {

    @Autowired
    ReviewerService service;


    @PostMapping("/addReviewer")
    public ResponseEntity createReviewer(@RequestBody Reviewer newReviewer)
    {
        try {
            return ResponseEntity.ok(service.createReviewer(newReviewer));
        }
        catch (NullReviewerIdException | InvalidReviewerIdException ex)
        {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/reviewer/{reviewerId}")
    public ResponseEntity getReviewerById(@PathVariable Integer reviewerId)
    {
        try {
            return ResponseEntity.ok(service.getReviewerById(reviewerId));
        }
        catch (NullReviewerIdException | InvalidReviewerIdException ex)
        {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/reviewers")
    public ResponseEntity getReviewers()
    {
        try {
            return ResponseEntity.ok(service.getAllReviewers());
        }
        catch (NullReviewerIdException | InvalidReviewerIdException ex)
        {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }


    @PutMapping("/updateReviewer/{reviewerId}")
    public ResponseEntity editReviewerById(@RequestBody Reviewer newReviewer)

    {
        try {
            return ResponseEntity.ok(service.updateReviewer(newReviewer));
        }
        catch (NullReviewerIdException | InvalidReviewerIdException ex)
        {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }


    @DeleteMapping("/deleteReviewer/{reviewerId}")

    public String deleteReviewerById(@PathVariable Integer reviewerId)
    {
        String toReturn = "";

        try {
            if (service.destroy(reviewerId)) {
                toReturn = "Reviewer " + reviewerId + " deleted";
            } else {
                toReturn = "Reviewer " + reviewerId + " not found";
            }
        }
        catch (NullReviewerIdException | InvalidReviewerIdException ex)
        {
            ex.getMessage();
        }

        return toReturn;
    }

}
