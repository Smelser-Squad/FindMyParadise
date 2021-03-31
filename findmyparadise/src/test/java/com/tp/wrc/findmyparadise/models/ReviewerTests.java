package com.tp.wrc.findmyparadise.models;

import com.tp.wrc.findmyparadise.repositories.ReviewerRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;


import java.time.LocalDate;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ReviewerTests {

    @Autowired
    ReviewerRepository repo;

    @Test
    @Rollback(false)
    @Order(1)
    public void testCreateReviewer(){
        Reviewer reviewer = new Reviewer("Image src", "Test Description", LocalDate.of(2021, 03, 25), "Rahman");
        repo.save(reviewer);
        assertNotNull(reviewer);
    }

    @Test
    @Order(2)
    public void testFindByNameExist(){
        String name = "Rahman";
        Reviewer reviewer = repo.findByName(name);
        assertThat(reviewer.getName()).isEqualTo(name);

    }

    @Test
    @Order(3)
    public void testFindByNameNotExist(){
        String name = "Raha";
        Reviewer reviewer = repo.findByName(name);
        assertNull(reviewer);
    }

    @Test
    @Rollback(false)
    @Order(5)
    public void testUpdateReviewer(){
        String reviewerName = "Yesrat";
        Reviewer reviewer = new Reviewer("Image src", "Test Description", LocalDate.of(2021, 03, 25),reviewerName);
        reviewer.setReviewerId(1);
        repo.save(reviewer);

        Reviewer updateReviewer = repo.findByName(reviewerName);
        assertThat(updateReviewer.getName()).isEqualTo(reviewerName);
    }

    @Test
    @Order(4)
    public void testListReviewers(){
        List<Reviewer> reviewers = repo.findAll();
//        assertThat(reviewers).size().isGreaterThan(0);
    }

    @Test
    @Rollback(false)
    @Order(6)
    public void testDeleteReviewer(){
        Integer id = 1;
        boolean isExistBeforeDelete = repo.findById(id).isPresent();
        repo.deleteById(id);

        boolean notExistAfterDelete = repo.findById(id).isPresent();
        assertTrue(isExistBeforeDelete);
        assertFalse(notExistAfterDelete);
    }
}
