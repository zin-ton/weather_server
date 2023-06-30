package com.example.weather_server.database;

import com.example.weather_server.json_weather.WeatherJson;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class WindEntity {
    @jakarta.persistence.Id
    @GeneratedValue
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private DatabaseEntity database;
    private double speed;
    private double deg;

    public WindEntity(WeatherJson weatherJson) {
        this.speed = weatherJson.getWind().getSpeed();
        this.deg = weatherJson.getWind().getDeg();
    }

    public WindEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DatabaseEntity getDatabase() {
        return database;
    }

    public void setDatabase(DatabaseEntity database) {
        this.database = database;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDeg() {
        return deg;
    }

    public void setDeg(double deg) {
        this.deg = deg;
    }
}
