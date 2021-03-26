package com.tp.wrc.findmyparadise.services;


import com.tp.wrc.findmyparadise.exceptions.InvalidReviewerIdException;
import com.tp.wrc.findmyparadise.exceptions.NullReviewerIdException;
import com.tp.wrc.findmyparadise.models.Event;
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
        assertEquals("Event Title", event.getTitle());
        assertEquals("Event Category", event.getCategory());
        assertEquals("Event Summary", event.getSummary());
        assertEquals(0, event.getCost());
        assertEquals(0, event.getLatitude());
        assertEquals(0, event.getLongitude());

    }
}
