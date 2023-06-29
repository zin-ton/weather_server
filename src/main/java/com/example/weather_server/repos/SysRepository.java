package com.example.weather_server.repos;

import com.example.weather_server.database.SysEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysRepository extends JpaRepository<SysEntity, Long> {
}
