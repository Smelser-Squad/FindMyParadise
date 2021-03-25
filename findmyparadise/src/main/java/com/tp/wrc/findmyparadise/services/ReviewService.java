package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.exceptions.InvalidHostIDException;
import com.tp.wrc.findmyparadise.exceptions.InvalidReviewIdException;
import com.tp.wrc.findmyparadise.exceptions.NullReviewIdException;
import com.tp.wrc.findmyparadise.models.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {
    List<Review> getAll() throws InvalidReviewIdException, NullReviewIdException;

    Review show(Integer reviewId) throws InvalidReviewIdException, NullReviewIdException;

    Review create(Review newReview) throws InvalidReviewIdException, NullReviewIdException;

     Review update(Integer reviewId, Review newReview) throws InvalidReviewIdException, NullReviewIdException;

     boolean destroy(Integer reviewId) throws InvalidReviewIdException, NullReviewIdException;
}
