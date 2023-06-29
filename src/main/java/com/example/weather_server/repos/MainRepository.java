package com.example.weather_server.repos;

import com.example.weather_server.database.MainEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MainRepository extends JpaRepository<MainEntity, Long> {
}
