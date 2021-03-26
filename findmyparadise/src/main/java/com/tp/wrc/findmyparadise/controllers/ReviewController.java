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
<<<<<<< HEAD
@CrossOrigin(origins="http://localhost:8081")
=======
@CrossOrigin(origins ="http://localhost:8081")
>>>>>>> 3f0940a3dd6433e913e711f61b17a406a77c9ca6
public class ReviewController {

    @Autowired
    ReviewService service;


    @PostMapping("/addReview")
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
            return ResponseEntity.ok(service.getReviewById(reviewId));
        }
        catch (NullReviewIdException | InvalidReviewIdException ex)
        {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/reviews")
    public ResponseEntity getReviews()
    {

            return ResponseEntity.ok(service.getAllReviews());


    }


    @PutMapping("/updateReview/{reviewId}")
    public ResponseEntity editReviewById(@RequestBody Review newReview)

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
