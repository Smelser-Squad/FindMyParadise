package com.tp.wrc.findmyparadise.controllers;
import com.tp.wrc.findmyparadise.exceptions.InvalidReviewIdException;
import com.tp.wrc.findmyparadise.exceptions.NullReviewIdException;
import com.tp.wrc.findmyparadise.models.Review;
import com.tp.wrc.findmyparadise.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins ="http://localhost:8081")
public class ReviewController {

    @Autowired
    ReviewService service;


    @PostMapping("/review")
    public ResponseEntity createReview(@RequestBody Review newReview)
    {
        try {
            return ResponseEntity.ok(service.create(newReview));
        }
        catch (NullReviewIdException | InvalidReviewIdException ex)
        {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/review/{reviewId}")
    public ResponseEntity getReviewById(@PathVariable Integer reviewId)
    {
        try {
            return ResponseEntity.ok(service.show(reviewId));
        }
        catch (NullReviewIdException | InvalidReviewIdException ex)
        {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/reviews")
    public ResponseEntity getReviews()
    {
        try {
            return ResponseEntity.ok(service.getAll());
        }
        catch (NullReviewIdException | InvalidReviewIdException ex)
        {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }


    @PutMapping("/updateReview/{reviewId}")
    public ResponseEntity editReviewById(@PathVariable Integer reviewId, @RequestBody Review newReview)

    {
        try {
            return ResponseEntity.ok(service.update(newReview));
        }
        catch (NullReviewIdException | InvalidReviewIdException ex)
        {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }


    @DeleteMapping("/deleteReview/{reviewId}")

    public String deleteReviewById(@PathVariable Integer reviewId)
    {
        String toReturn = "";

        try {
            if (service.destroy(reviewId)) {
                toReturn = "Review " + reviewId + " deleted";
            } else {
                toReturn = "Review " + reviewId + " not found";
            }
        }
        catch (NullReviewIdException | InvalidReviewIdException ex)
        {
            ex.getMessage();
        }

        return toReturn;
    }

}
