package com.tp.wrc.findmyparadise.repositories;

import com.tp.wrc.findmyparadise.models.Reviewer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewerRepository extends JpaRepository<Reviewer, Integer> {

     Reviewer findByName(String name);
}
