package com.tp.wrc.findmyparadise.services;
import com.tp.wrc.findmyparadise.exceptions.*;
import com.tp.wrc.findmyparadise.models.Amenity;
import com.tp.wrc.findmyparadise.models.Review;
import com.tp.wrc.findmyparadise.models.Reviewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.testng.Assert.fail;

@SpringBootTest
public class ReviewServiceImplTests {

    @Autowired
    ReviewServiceImpl toTest;

    @Test
    public void createReviewGoldenPathTest(){
        Review review = new Review();
        review.setRating(1);
        review.setReviewText("test review text");
        review.setCommunicationRating(1);
        review.setCheckInRating(1);
        review.setValueRating(1);
        review.setLocationRating(1);
        review.setCleanlinessRating(1);
        review.setAccuracyRating(1);
        Reviewer reviewer = new Reviewer();

       reviewer.setImageSrc("Test Image Source");
       reviewer.setDescription("Test Description data");
       reviewer.setName("Rahman");
       reviewer.setJoinedDate(LocalDate.of(2021, 03, 25));

        review.setReviewer(reviewer);

       try{
           toTest.create(review);
       }
       catch (InvalidReviewIdException | NullReviewIdException e ){
           fail();
       }

        assertEquals(1, review.getRating());
        assertEquals("test review text", review.getReviewText());
        assertEquals(1, review.getCommunicationRating());
        assertEquals(1, review.getCheckInRating());
        assertEquals(1, review.getValueRating());
        assertEquals(1, review.getLocationRating());
        assertEquals(1, review.getCleanlinessRating());
        assertEquals(1, review.getAccuracyRating());
        assertEquals("Rahman", review.getReviewer().getName());
        assertEquals("Test Image Source", review.getReviewer().getImageSrc());
        assertEquals("Test Description data", review.getReviewer().getDescription());
        assertEquals(LocalDate.of(2021, 03, 25), review.getReviewer().getJoinedDate());

    }

    @Test
    public void getAllReviewsGoldenPathTest() {
        Review review = new Review();
        review.setRating(1);
        review.setReviewText("test review text");
        review.setCommunicationRating(1);
        review.setCheckInRating(1);
        review.setValueRating(1);
        review.setLocationRating(1);
        review.setCleanlinessRating(1);
        review.setAccuracyRating(1);

        Reviewer reviewer = new Reviewer();

        reviewer.setImageSrc("Test Image Source");
        reviewer.setDescription("Test Description data");
        reviewer.setName("Rahman");
        reviewer.setJoinedDate(LocalDate.of(2021, 03, 25));
        review.setReviewer(reviewer);
        try{
            toTest.create(review);
        }
        catch (InvalidReviewIdException | NullReviewIdException e ){
            fail();
        }


        Review review1 = new Review();
        review1.setRating(2);
        review1.setReviewText("test review text2");
        review1.setCommunicationRating(2);
        review1.setCheckInRating(2);
        review1.setValueRating(2);
        review1.setLocationRating(2);
        review1.setCleanlinessRating(2);
        review1.setAccuracyRating(2);

        Reviewer reviewer2 = new Reviewer();

        reviewer2.setImageSrc("Test Image Source2");
        reviewer2.setDescription("Test Description data2");
        reviewer2.setName("Rahman2");
        reviewer2.setJoinedDate(LocalDate.of(2020, 03, 25));
        review1.setReviewer(reviewer2);

        try{
            toTest.create(review1);
        }
        catch (InvalidReviewIdException | NullReviewIdException e ){
            fail();
        }

        List<Review> reviews = new ArrayList<>();
        try {
            reviews = toTest.getAllReviews();
        }
        catch (Exception e) {
            Assertions.fail();
        }

        assertEquals(3, reviews.size());

        assertEquals(1, review.getRating());
        assertEquals("test review text", review.getReviewText());
        assertEquals(1, review.getCommunicationRating());
        assertEquals(1, review.getCheckInRating());
        assertEquals(1, review.getValueRating());
        assertEquals(1, review.getLocationRating());
        assertEquals(1, review.getCleanlinessRating());
        assertEquals(1, review.getAccuracyRating());
        assertEquals("Rahman", review.getReviewer().getName());
        assertEquals("Test Image Source", review.getReviewer().getImageSrc());
        assertEquals("Test Description data", review.getReviewer().getDescription());
        assertEquals(LocalDate.of(2021, 03, 25), review.getReviewer().getJoinedDate());

        assertEquals(2, review1.getRating());
        assertEquals("test review text2", review1.getReviewText());
        assertEquals(2, review1.getCommunicationRating());
        assertEquals(2, review1.getCheckInRating());
        assertEquals(2, review1.getValueRating());
        assertEquals(2, review1.getLocationRating());
        assertEquals(2, review1.getCleanlinessRating());
        assertEquals(2, review1.getAccuracyRating());
        assertEquals("Rahman2", review1.getReviewer().getName());
        assertEquals("Test Image Source2", review1.getReviewer().getImageSrc());
        assertEquals("Test Description data2", review1.getReviewer().getDescription());
        assertEquals(LocalDate.of(2020, 03, 25), review1.getReviewer().getJoinedDate());
    }



    @Test
    public void findReviewByIdGoldenPath() {

        Review review = new Review();
        try {
            review = toTest.getReviewById(1);
        }
        catch (InvalidReviewIdException | NullReviewIdException e ){
           fail();
        }

        assertEquals(1, review.getReviewId());
        assertEquals(1, review.getRating());
        assertEquals("test review text", review.getReviewText());
        assertEquals(1, review.getCommunicationRating());
        assertEquals(1, review.getCheckInRating());
        assertEquals(1, review.getValueRating());
        assertEquals(1, review.getLocationRating());
        assertEquals(1, review.getCleanlinessRating());
        assertEquals(1, review.getAccuracyRating());
        assertEquals("Rahman", review.getReviewer().getName());
        assertEquals("Test Image Source", review.getReviewer().getImageSrc());
        assertEquals("Test Description data", review.getReviewer().getDescription());
        assertEquals(LocalDate.of(2021, 03, 25), review.getReviewer().getJoinedDate());

    }

    @Test
    public void findReviewByIdNullReviewIdTest() {

        assertThrows(NullReviewIdException.class, () -> toTest.getReviewById(null));

    }

    @Test
    public void findReviewByIdInvalidIdTest() {

        assertThrows(InvalidReviewIdException.class, () -> toTest.getReviewById(20));

    }

    @Test
    public void updateReviewGoldenPath() {
        Review review = new Review();
        review.setRating(1);
        review.setReviewText("test review text");
        review.setCommunicationRating(1);
        review.setCheckInRating(1);
        review.setValueRating(1);
        review.setLocationRating(1);
        review.setCleanlinessRating(1);
        review.setAccuracyRating(1);

        Reviewer reviewer = new Reviewer();
        reviewer.setImageSrc("Test Image Source");
        reviewer.setDescription("Test Description data");
        reviewer.setName("Rahman");
        reviewer.setJoinedDate(LocalDate.of(2021, 03, 25));
        review.setReviewer(reviewer);

        try {
           review = toTest.create(review);
        }
    catch (InvalidReviewIdException | NullReviewIdException e){
        fail();

    }

        try {
            toTest.update(review);
        } catch (InvalidReviewIdException | NullReviewIdException e) {
            fail();
        }


    }

    @Test
    public void updateNullReviewIdTest() {
        Review review = new Review();
        review.setReviewId(null);
        review.setReviewText("test");
        assertThrows(NullReviewIdException.class, () -> toTest.update(review));

    }

    @Test
    public void deleteReviewGoldenPath() {
        try{
            toTest.destroy(1);
            assertEquals(0, toTest.getAllReviews().size());
        }catch (InvalidReviewIdException | NullReviewIdException e){
            fail();
        }

    }

    @Test
    public void deleteNullReviewIdTest() {

        assertThrows(NullReviewIdException.class, () -> toTest.destroy(null));

    }


}
