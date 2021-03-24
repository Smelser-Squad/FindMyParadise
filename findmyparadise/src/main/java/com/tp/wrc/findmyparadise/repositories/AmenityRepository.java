package com.tp.wrc.findmyparadise.repositories;

import com.tp.wrc.findmyparadise.models.Amenity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmenityRepository extends JpaRepository<Amenity, Integer> {

     Amenity findByCategory(String category);

}
