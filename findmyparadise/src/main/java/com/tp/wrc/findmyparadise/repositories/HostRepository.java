package com.tp.wrc.findmyparadise.repositories;

import com.tp.wrc.findmyparadise.models.Host;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HostRepository extends JpaRepository<Host, Integer> {

}
