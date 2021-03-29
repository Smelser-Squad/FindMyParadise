package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.exceptions.InvalidReviewerIdException;
import com.tp.wrc.findmyparadise.exceptions.NullReviewerIdException;
import com.tp.wrc.findmyparadise.models.Reviewer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.testng.Assert.fail;

@SpringBootTest
public class ReviewerServiceImplTests {

    @Autowired
    ReviewerServiceImpl toTest;

    @Test
    public void createReviewerGoldenPathTest(){
        Reviewer reviewer = new Reviewer();
        reviewer.setImageSrc("Test Image Source");
        reviewer.setDescription("Test Description data");
        reviewer.setName("Rahman");
        reviewer.setJoinedDate(LocalDate.of(2021, 03, 25));

        try{
            toTest.createReviewer(reviewer);
        }
        catch (InvalidReviewerIdException | NullReviewerIdException e ){
            fail();
        }

        assertEquals("Rahman", reviewer.getName());
        assertEquals("Test Image Source", reviewer.getImageSrc());
        assertEquals("Test Description data", reviewer.getDescription());
        assertEquals(LocalDate.of(2021, 03, 25), reviewer.getJoinedDate());
    }

    @Test
    public void getAllReviewersGoldenPathTest() {

        Reviewer reviewer = new Reviewer();
        reviewer.setImageSrc("Test Image Source");
        reviewer.setDescription("Test Description data");
        reviewer.setName("Rahman");
        reviewer.setJoinedDate(LocalDate.of(2021, 03, 25));

        try {
            toTest.createReviewer(reviewer);
        } catch (InvalidReviewerIdException | NullReviewerIdException e) {
            fail();
        }


        Reviewer reviewer1 = new Reviewer();
        reviewer1.setImageSrc("Test Image Source1");
        reviewer1.setDescription("Test Description data1");
        reviewer1.setName("Rahman1");
        reviewer1.setJoinedDate(LocalDate.of(2020, 03, 25));

        try {
            toTest.createReviewer(reviewer1);
        } catch (InvalidReviewerIdException | NullReviewerIdException e) {
            fail();
        }

        List<Reviewer> reviewers = new ArrayList<>();
        try {
            reviewers = toTest.getAllReviewers();
        } catch (Exception e) {
            fail();
        }
        assertEquals(2, reviewers.size());

    }

    @Test
    public void findReviewerByIdGoldenPath() {

        Reviewer reviewer = new Reviewer();
        try {
            reviewer = toTest.getReviewerById(1);
        } catch (InvalidReviewerIdException | NullReviewerIdException e) {
            fail();
        }

        assertEquals(1, reviewer.getReviewerId());
        assertEquals("Rahman", reviewer.getName());
        assertEquals("Test Image Source", reviewer.getImageSrc());
        assertEquals("Test Description data", reviewer.getDescription());
        assertEquals(LocalDate.of(2021, 03, 25), reviewer.getJoinedDate());

    }

    @Test
    public void findReviewerByIdNullReviewerIdTest() {

        assertThrows(NullReviewerIdException.class, () -> toTest.getReviewerById(null));

    }

    @Test
    public void findReviewerByIdInvalidIdTest() {

        assertThrows(InvalidReviewerIdException.class, () -> toTest.getReviewerById(20));

    }

    @Test
    public void updateReviewerGoldenPath() {
        Reviewer reviewer = new Reviewer();
        reviewer.setImageSrc("Test Image Source");
        reviewer.setDescription("Test Description data");
        reviewer.setName("Rahman");
        reviewer.setJoinedDate(LocalDate.of(2021, 03, 25));



        try {
            reviewer = toTest.createReviewer(reviewer);
        }
        catch (InvalidReviewerIdException | NullReviewerIdException e){
            fail();

        }

        try {
            toTest.updateReviewer(reviewer);
        } catch (InvalidReviewerIdException | NullReviewerIdException e) {
            fail();
        }


    }

    @Test
    public void updateNullReviewerIdTest() {
        Reviewer reviewer = new Reviewer();
        reviewer.setReviewerId(null);
        assertThrows(NullReviewerIdException.class, () -> toTest.updateReviewer(reviewer));

    }

//    @Test
//    public void deleteReviewerGoldenPath() {
//        try{
//            toTest.destroy(1);
//            assertEquals(0, toTest.getAllReviewers().size());
//        }catch (InvalidReviewerIdException | NullReviewerIdException e){
//            fail();
//        }
//
//    }

    @Test
    public void deleteNullReviewerIdTest() {

        assertThrows(NullReviewerIdException.class, () -> toTest.destroy(null));

    }


}
