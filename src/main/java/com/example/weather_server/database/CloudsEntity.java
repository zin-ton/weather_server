package com.example.weather_server.database;

import com.example.weather_server.json_weather.WeatherJson;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class CloudsEntity {
    @jakarta.persistence.Id
    @GeneratedValue
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private DatabaseEntity database;
    private int all_clouds;

    public CloudsEntity(WeatherJson weatherJson) {
        this.all_clouds = (int) weatherJson.getClouds().getAll();
    }

    public CloudsEntity() {

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

    public int getAll_clouds() {
        return all_clouds;
    }

    public void setAll_clouds(int all_clouds) {
        this.all_clouds = all_clouds;
    }
}

