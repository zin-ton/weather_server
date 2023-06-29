package com.example.weather_server.repos;

import com.example.weather_server.database.CloudsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CloudsRepository extends JpaRepository<CloudsEntity, Long> {
}
