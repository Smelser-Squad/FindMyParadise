package com.tp.wrc.findmyparadise.services;
import com.tp.wrc.findmyparadise.exceptions.InvalidReviewerIdException;
import com.tp.wrc.findmyparadise.exceptions.NullReviewerIdException;
import com.tp.wrc.findmyparadise.models.Reviewer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ReviewerService {

    List<Reviewer> getAllReviewers() throws InvalidReviewerIdException, NullReviewerIdException;

    Reviewer getReviewerById(Integer reviewerId) throws InvalidReviewerIdException, NullReviewerIdException;

    Reviewer createReviewer(Reviewer newReviewer) throws InvalidReviewerIdException, NullReviewerIdException;

    Reviewer updateReviewer(Reviewer newReviewer) throws InvalidReviewerIdException, NullReviewerIdException;

    boolean destroy(Integer reviewerId) throws InvalidReviewerIdException, NullReviewerIdException;
}
