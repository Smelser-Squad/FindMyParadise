package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.exceptions.InvalidAmenityIdException;
import com.tp.wrc.findmyparadise.exceptions.NullAmenityIdException;
import com.tp.wrc.findmyparadise.exceptions.NullCategoryException;
import com.tp.wrc.findmyparadise.models.Amenity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AmenityServiceImplTests {

    @Autowired
    AmenityServiceImpl toTest;

    @Test
    public void createGoldenPath() {

        Amenity amenity = new Amenity();
        amenity.setAmenityName("Test Name");
        amenity.setAmenityCategory("Test Category");

        try {
            toTest.create(amenity);
        }
        catch (Exception e) {
            fail();
        }

        assertEquals(1, amenity.getAmenityId());
        assertEquals("Test Name", amenity.getAmenityName());
        assertEquals("Test Category", amenity.getAmenityCategory());

    }

    @Test
    public void getAllAmenitiesGoldenPath() {

        Amenity amenity = new Amenity();
        amenity.setAmenityName("Test Name");
        amenity.setAmenityCategory("Test Category");
        toTest.create(amenity);

        Amenity amenity2 = new Amenity();
        amenity2.setAmenityName("Test 2 Name");
        amenity2.setAmenityCategory("Test 2 Category");
        toTest.create(amenity2);

        List<Amenity> toCheck = new ArrayList<>();
        try {
            toCheck = toTest.getAllAmenities();
        }
        catch (Exception e) {
            fail();
        }

        assertEquals(3, toCheck.size());

        assertEquals(2, toCheck.get(1).getAmenityId());
        assertEquals("Test Name", toCheck.get(1).getAmenityName());
        assertEquals("Test Category", toCheck.get(1).getAmenityCategory());

        assertEquals(3, toCheck.get(2).getAmenityId());
        assertEquals("Test 2 Name", toCheck.get(2).getAmenityName());
        assertEquals("Test 2 Category", toCheck.get(2).getAmenityCategory());

    }

    @Test
    public void findAmenityByIdGoldenPath() {

        Amenity toCheck = new Amenity();
        try {
            toCheck = toTest.findAmenityById(1);
        }
        catch (NullAmenityIdException | InvalidAmenityIdException e) {
            fail();
        }

        assertEquals(1, toCheck.getAmenityId());
        assertEquals("Test Name", toCheck.getAmenityName());
        assertEquals("Test Category", toCheck.getAmenityCategory());

    }

    @Test
    public void findAmenityByIdNullAmenityIdTest() {

        assertThrows(NullAmenityIdException.class, () -> toTest.findAmenityById(null));

    }

    @Test
    public void findAmenityByIdInvalidIdTest() {

        assertThrows(InvalidAmenityIdException.class, () -> toTest.findAmenityById(100000));

    }

    @Test
    public void findAmenityByCategoryGoldenPath() {

        List<Amenity> toCheck = new ArrayList<>();
        try {
            List<Amenity> toDebug = toTest.getAllAmenities();
            toCheck = toTest.findAmenityByCategory("Test Category");
        }
        catch (Exception e) {
            fail();
        }

        assertEquals(1, toCheck.size());

        assertEquals(2, toCheck.get(0).getAmenityId());
        assertEquals("Test Name", toCheck.get(0).getAmenityName());
        assertEquals("Test Category", toCheck.get(0).getAmenityCategory());

    }

    @Test
    public void findAmenityByCategoryNullCategoryTest() {

        assertThrows(NullCategoryException.class, () -> toTest.findAmenityByCategory(null));

    }

    @Test
    public void updateGoldenPath() {

        Amenity amenity = new Amenity();
        amenity.setAmenityId(1);
        amenity.setAmenityName("Update Test Name");
        amenity.setAmenityCategory("Update Test Category");

        try {
            toTest.update(amenity);
        } catch (InvalidAmenityIdException | NullAmenityIdException e) {
            fail();
        }

        Amenity toCheck = new Amenity();
        try {
            toCheck = toTest.findAmenityById(1);
        } catch (NullAmenityIdException | InvalidAmenityIdException e) {
            fail();
        }

        assertEquals(1, toCheck.getAmenityId());
        assertEquals("Update Test Name", toCheck.getAmenityName());
        assertEquals("Update Test Category", toCheck.getAmenityCategory());

    }

    @Test
    public void updateNullAmenityIdTest() {
        Amenity amenity = new Amenity();
        amenity.setAmenityId(null);
        amenity.setAmenityName("Update Test Name");
        amenity.setAmenityCategory("Update Test Category");

        assertThrows(NullAmenityIdException.class, () -> toTest.update(amenity));

    }

    @Test
    public void deleteGoldenPath() {

        Amenity amenity = new Amenity();
        amenity.setAmenityName("To Delete");
        amenity.setAmenityCategory("To Delete");

        toTest.create(amenity);

        assertEquals(4, toTest.getAllAmenities().size());

        assertEquals(4, toTest.getAllAmenities().get(3).getAmenityId());
        assertEquals("To Delete", toTest.getAllAmenities().get(3).getAmenityName());
        assertEquals("To Delete", toTest.getAllAmenities().get(3).getAmenityCategory());

        try {
            toTest.destroy(4);
        } catch (NullAmenityIdException | InvalidAmenityIdException e) {
            fail();
        }

        assertEquals(3, toTest.getAllAmenities().size());

    }


}
