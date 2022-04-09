package com.graduation.backend.repository;

import com.graduation.backend.model.TravelTips;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelTipsRepository extends JpaRepository<TravelTips, Long> {
}
