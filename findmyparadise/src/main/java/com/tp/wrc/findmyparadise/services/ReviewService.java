package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.exceptions.InvalidHostIDException;
import com.tp.wrc.findmyparadise.exceptions.InvalidReviewIdException;

import com.tp.wrc.findmyparadise.exceptions.NullHostIDException;
import com.tp.wrc.findmyparadise.exceptions.NullReviewException;
import com.tp.wrc.findmyparadise.models.Host;
import com.tp.wrc.findmyparadise.models.Review;

import java.util.List;

public interface ReviewService {

    List<Review> getAll();

    Review show(Integer reviewId) throws InvalidReviewIdException, NullReviewException;

    Review create(Review newReview) throws InvalidReviewIdException, NullReviewException;

    Review update(Integer reviewId, Review newReview) throws InvalidReviewIdException, NullReviewException;

    boolean destroy(Integer reviewId) throws InvalidReviewIdException, NullReviewException;
}
