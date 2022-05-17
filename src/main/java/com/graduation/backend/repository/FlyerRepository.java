package com.graduation.backend.repository;

import com.graduation.backend.model.Flyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlyerRepository extends JpaRepository<Flyer, Long> {
}
