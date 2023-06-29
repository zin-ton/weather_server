package com.example.weather_server.database;

import com.example.weather_server.json_weather.WeatherJson;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class CoordEntity {
    @jakarta.persistence.Id
    @GeneratedValue
    private Long id;
    private double lon;
    private double lat;
    @OneToOne
    @JoinColumn(name = "user_id")
    private DatabaseEntity database;

    public CoordEntity(WeatherJson weatherJson) {
        this.lon = weatherJson.getCoordinates().getLongitude();
        this.lat = weatherJson.getCoordinates().getLatitude();
    }

    public CoordEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public DatabaseEntity getDatabase() {
        return database;
    }

    public void setDatabase(DatabaseEntity database) {
        this.database = database;
    }
}
