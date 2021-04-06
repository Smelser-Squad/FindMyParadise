package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.exceptions.InvalidListingIDException;
import com.tp.wrc.findmyparadise.exceptions.InvalidReviewIdException;
import com.tp.wrc.findmyparadise.exceptions.NoListingFoundException;
import com.tp.wrc.findmyparadise.exceptions.NullReviewIdException;
import com.tp.wrc.findmyparadise.models.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {
    List<Review> getAllReviews();

    Review getReviewById(Integer reviewId) throws InvalidReviewIdException, NullReviewIdException;

    Review create(Review newReview, Integer listingId) throws InvalidReviewIdException, NullReviewIdException, InvalidListingIDException, NoListingFoundException;

     Review update(Review newReview) throws InvalidReviewIdException, NullReviewIdException;

     boolean destroy(Integer reviewId) throws InvalidReviewIdException, NullReviewIdException;
}
