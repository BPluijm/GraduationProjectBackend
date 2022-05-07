package com.graduation.backend.repository;

import com.graduation.backend.model.Travels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelsRepository extends JpaRepository<Travels, Long> {
}
