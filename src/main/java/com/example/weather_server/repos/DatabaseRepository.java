package com.example.weather_server.repos;

import com.example.weather_server.database.DatabaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DatabaseRepository extends JpaRepository<DatabaseEntity, Long> {
    List<DatabaseEntity> findByUserId(Long userId);
}
