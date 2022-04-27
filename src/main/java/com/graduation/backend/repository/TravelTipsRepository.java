package com.graduation.backend.repository;

import com.graduation.backend.model.TravelTips;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelTipsRepository extends JpaRepository<TravelTips, Long> {
}
