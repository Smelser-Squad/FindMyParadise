package com.tp.wrc.findmyparadise.models;

import com.tp.wrc.findmyparadise.repositories.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ReviewTests {
    @Autowired
    ReviewRepository repo;

    @Test
    public void createReview(){
//        Review review = new Review();

    }
}
