package com.graduation.backend.repository;

import com.graduation.backend.model.FutureTravels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FutureTravelsRepository extends JpaRepository<FutureTravels, Long> {
}
