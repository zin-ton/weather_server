package com.example.weather_server.repos;

import com.example.weather_server.database.CoordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoordRepository extends JpaRepository<CoordEntity, Long> {
}
