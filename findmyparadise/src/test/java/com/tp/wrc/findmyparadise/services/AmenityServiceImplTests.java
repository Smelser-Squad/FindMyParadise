package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.exceptions.InvalidAmenityIdException;
import com.tp.wrc.findmyparadise.exceptions.NullAmenityIdException;
import com.tp.wrc.findmyparadise.exceptions.NullCategoryException;
import com.tp.wrc.findmyparadise.models.Amenity;
import com.tp.wrc.findmyparadise.repositories.AmenityRepository;
import org.junit.jupiter.api.BeforeEach;
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
    public void findAmenityByIdNullAmenityIdTest() {

        assertThrows(NullAmenityIdException.class, () -> toTest.findAmenityById(null));

    }

    @Test
    public void findAmenityByIdInvalidIdTest() {

        assertThrows(InvalidAmenityIdException.class, () -> toTest.findAmenityById(100000));

    }

    @Test
    public void findAmenityByCategoryNullCategoryTest() {

        assertThrows(NullCategoryException.class, () -> toTest.findAmenityByCategory(null));

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
    public void deleteNullAmenityIdTest() {

        assertThrows(NullAmenityIdException.class, () -> toTest.destroy(null));

    }

}
