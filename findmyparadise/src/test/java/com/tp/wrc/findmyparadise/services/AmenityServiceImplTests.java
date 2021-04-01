package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.exceptions.InvalidAmenityIdException;
import com.tp.wrc.findmyparadise.exceptions.NullAmenityIdException;
import com.tp.wrc.findmyparadise.exceptions.NullCategoryException;
import com.tp.wrc.findmyparadise.models.Amenity;
import com.tp.wrc.findmyparadise.repositories.AmenityRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class AmenityServiceImplTests {

    @InjectMocks
    AmenityServiceImpl toTest;

    @Mock
    AmenityRepository repo;

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
