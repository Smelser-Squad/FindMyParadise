package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.exceptions.InvalidReviewerIdException;
import com.tp.wrc.findmyparadise.exceptions.NullReviewerIdException;
import com.tp.wrc.findmyparadise.models.Reviewer;
import com.tp.wrc.findmyparadise.repositories.ReviewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ReviewerServiceImpl implements ReviewerService {

    @Autowired
    ReviewerRepository reviewerRepo;

    @Override
    public List<Reviewer> getAllReviewers()  {
        return reviewerRepo.findAll();
    }

    @Override
    public Reviewer show(Integer reviewerId) throws InvalidReviewerIdException, NullReviewerIdException {
        if(reviewerId==null){
            throw new NullReviewerIdException("Null reviewer id entered");
        }
        Reviewer newReviewer = null;
        Optional<Reviewer> opt = reviewerRepo.findById(reviewerId);
        if (opt.isPresent()) {
            newReviewer = opt.get();

            return newReviewer;
        } else {
            throw new InvalidReviewerIdException("Reviewer doesn't exist with this id");
        }
    }

    @Override
    public Reviewer create(Reviewer newReviewer) throws InvalidReviewerIdException, NullReviewerIdException {
        return reviewerRepo.saveAndFlush(newReviewer);
    }

    @Override
    public Reviewer update(Reviewer newReviewer) throws InvalidReviewerIdException, NullReviewerIdException {
        Reviewer toAdd = reviewerRepo.findById(newReviewer.getReviewerId()).get();

        if (toAdd != null) {

            toAdd.setName(newReviewer.getName());
            toAdd.setImageSrc(newReviewer.getImageSrc());
            toAdd.setDescription(newReviewer.getDescription());
            toAdd.setJoinedDate(newReviewer.getJoinedDate());

            return reviewerRepo.saveAndFlush(toAdd);
        } else {
            throw new InvalidReviewerIdException("Reviewer doesn't exist with this id");
        }
    }

    @Override
    public boolean destroy(Integer reviewerId) throws InvalidReviewerIdException, NullReviewerIdException {
        if(reviewerId==null){
            throw new NullReviewerIdException("Null reviewer id entered");
        }
        Reviewer newReviewer = reviewerRepo.findById(reviewerId).get();

        if (newReviewer != null) {
            reviewerRepo.delete(newReviewer);
            return true;
        } else {
            throw new InvalidReviewerIdException("Reviewer doesn't exist with this id");
        }
    }

}

