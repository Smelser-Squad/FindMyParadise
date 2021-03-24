package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.exceptions.InvalidReviewIdException;
import com.tp.wrc.findmyparadise.exceptions.NullReviewException;
import com.tp.wrc.findmyparadise.models.Review;
import com.tp.wrc.findmyparadise.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<Review> getAll()  {
        return reviewRepository.findAll();
    }

    @Override
    public Review show(Integer reviewId) throws InvalidReviewIdException, NullReviewException {
        return null;
    }

    @Override
    public Review create(Review newReview) throws InvalidReviewIdException, NullReviewException {
        return null;
    }

    @Override
    public Review update(Integer reviewId, Review newReview) throws InvalidReviewIdException, NullReviewException {
        return null;
    }

    @Override
    public boolean destroy(Integer reviewId) throws InvalidReviewIdException, NullReviewException {
        return false;
    }

}
