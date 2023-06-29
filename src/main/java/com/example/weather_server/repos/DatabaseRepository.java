package com.example.weather_server.repos;

import com.example.weather_server.database.DatabaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatabaseRepository extends JpaRepository<DatabaseEntity, Long> {
}
