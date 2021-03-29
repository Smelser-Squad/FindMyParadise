package com.tp.wrc.findmyparadise.repositories;

import com.tp.wrc.findmyparadise.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
