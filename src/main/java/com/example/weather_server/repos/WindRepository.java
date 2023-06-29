package com.example.weather_server.repos;

import com.example.weather_server.database.WindEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WindRepository extends JpaRepository<WindEntity, Long> {
}
