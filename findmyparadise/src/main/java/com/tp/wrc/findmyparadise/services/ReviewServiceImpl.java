package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.exceptions.InvalidReviewIdException;
import com.tp.wrc.findmyparadise.exceptions.NullAmenityIdException;
import com.tp.wrc.findmyparadise.exceptions.NullReviewIdException;
import com.tp.wrc.findmyparadise.models.Review;
import com.tp.wrc.findmyparadise.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepo;

    @Override
    public List<Review> getAllReviews()  {
        return reviewRepo.findAll();
    }

    @Override
    public Review getReviewById(Integer reviewId) throws InvalidReviewIdException, NullReviewIdException {
        if(reviewId==null){
            throw new NullReviewIdException("Null review id entered");
        }
        Review newReview = null;
        Optional<Review> opt = reviewRepo.findById(reviewId);
        if (opt.isPresent()) {
            newReview = opt.get();

            return newReview;
        } else {
            throw new InvalidReviewIdException("Review doesn't exist with this id");
        }
    }

    @Override
    public Review create(Review newReview) throws InvalidReviewIdException, NullReviewIdException {
        return reviewRepo.saveAndFlush(newReview);
    }

    @Override
    public Review update(Review newReview) throws InvalidReviewIdException, NullReviewIdException {
        if(newReview.getReviewId() == null)
            throw new NullReviewIdException("Review id is null.");

        Review toAdd = reviewRepo.findById(newReview.getReviewId()).get();

        if (toAdd != null) {

            toAdd.setRating(newReview.getRating());
            toAdd.setCleanlinessRating(newReview.getCleanlinessRating());
            toAdd.setLocationRating(newReview.getLocationRating());
            toAdd.setAccuracyRating(newReview.getAccuracyRating());
            toAdd.setValueRating(newReview.getValueRating());
            toAdd.setCheckInRating(newReview.getCheckInRating());
            toAdd.setCommunicationRating(newReview.getCommunicationRating());
            toAdd.setReviewer(newReview.getReviewer());
            return reviewRepo.saveAndFlush(toAdd);
        } else {
            throw new InvalidReviewIdException("Review doesn't exist with this id");
        }
    }

    @Override
    public boolean destroy(Integer reviewId) throws InvalidReviewIdException, NullReviewIdException {
        if(reviewId==null){
            throw new NullReviewIdException("Null review id entered");
        }
        Review newReview = reviewRepo.findById(reviewId).get();

        if (newReview != null) {
            reviewRepo.delete(newReview);
            return true;
        } else {
            throw new InvalidReviewIdException("Review doesn't exist with this id");
        }
    }

}

