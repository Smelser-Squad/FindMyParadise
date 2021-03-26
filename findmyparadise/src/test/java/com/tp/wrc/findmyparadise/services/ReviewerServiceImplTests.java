package com.tp.wrc.findmyparadise.services;


import com.tp.wrc.findmyparadise.exceptions.InvalidReviewerIdException;
import com.tp.wrc.findmyparadise.exceptions.NullReviewerIdException;
import com.tp.wrc.findmyparadise.models.Reviewer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest

public class ReviewerServiceImplTests {
    @Autowired
    ReviewerServiceImpl reviewerTest;

    public void setUp() throws NullReviewerIdException, InvalidReviewerIdException {

        Reviewer reviewer = new Reviewer();
        reviewer.setName("Raha Rahman");
        reviewer.setDescription("Good place to stay");
        reviewer.setImageSrc("test image source");
        reviewerTest.create(reviewer);

    }

    @AfterEach
    public void tearDown() {

    }

    @Test
    public void findReviewerByIdTest() throws NullReviewerIdException, InvalidReviewerIdException {
        Reviewer reviewer = reviewerTest.show(1);
        assertEquals("Raha Rahman", reviewer.getName());
        assertEquals("Good place to stay", reviewer.getDescription());
        assertEquals("test image source", reviewer.getImageSrc());


    }
}
