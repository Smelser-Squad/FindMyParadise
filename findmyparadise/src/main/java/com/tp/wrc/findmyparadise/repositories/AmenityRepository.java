package com.tp.wrc.findmyparadise.repositories;

import com.tp.wrc.findmyparadise.models.Amenity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmenityRepository extends JpaRepository<Amenity, Integer> {

     List<Amenity> findByCategory(String category);

}
