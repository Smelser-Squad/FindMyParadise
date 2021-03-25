package com.tp.wrc.findmyparadise.services;
import com.tp.wrc.findmyparadise.exceptions.InvalidReviewerIdException;
import com.tp.wrc.findmyparadise.exceptions.NullReviewerIdException;
import com.tp.wrc.findmyparadise.models.Reviewer;

import java.util.List;

public interface ReviewerService {

    List<Reviewer> getAllReviewers() throws InvalidReviewerIdException, NullReviewerIdException;

    Reviewer show(Integer reviewerId) throws InvalidReviewerIdException, NullReviewerIdException;

    Reviewer create(Reviewer newReviewer) throws InvalidReviewerIdException, NullReviewerIdException;

    Reviewer update(Reviewer newReviewer) throws InvalidReviewerIdException, NullReviewerIdException;

    boolean destroy(Integer reviewerId) throws InvalidReviewerIdException, NullReviewerIdException;
}
