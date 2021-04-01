package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.models.Photo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class PhotoGalleryServiceImplTest {

    @Autowired
    PhotoGalleryServiceImpl toTest;

    @BeforeEach
    public void setUp(){
        Photo photo = new Photo();
//        Listing listing = new Listing();
//        listing.setListingID(1);
        photo.setCategory("Bathroom");
        photo.setImageSrc("someLink");
//        photo.setListing(listing);
        toTest.addImage(photo);
    }

    @AfterEach
    public void reset(){

    }


    @Test
    public void getByIdTest(){
        Photo photo = toTest.getById(1);
        assertEquals("someLink", photo.getImageSrc());
        assertEquals("Bathroom",  photo.getCategory());
    }

    //TODO: fix issues with having to have an actual listing in db
//    @Test
//    public void getByListingTest(){
//        List<Photo> photo = toTest.getByListing(1);
//        assertEquals(1, photo.size());
//        assertEquals(1, photo.get(1).getPhotoID());
//        assertEquals("someLink", photo.get(1).getImageSrc());
//        assertEquals("Bathroom", photo.get(1).getCategory());
//        assertEquals(1, photo.get(1).getListing());
//    }


    @Test
    public void addImageTest(){
        Photo newPhoto = new Photo();
//        Listing listing = new Listing();
//        listing.setListingID(2);
//        newPhoto.setListing(listing);
        newPhoto.setImageSrc("someOtherLink");
        newPhoto.setCategory("Kitchen");

        newPhoto = toTest.addImage(newPhoto);
        Photo tester = toTest.getById(newPhoto.getPhotoId());

        assertEquals("someOtherLink", tester.getImageSrc());
        assertEquals("Kitchen", tester.getCategory());
        assertEquals(3, tester.getPhotoId());

    }

    @Test
    public void deletePhotoTest(){
        assertTrue(toTest.delete(3));
    }


}