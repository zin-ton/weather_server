package com.example.weather_server.database;

import com.example.weather_server.json_weather.WeatherJson;
import jakarta.persistence.*;

@Entity
public class SysEntity {
    @jakarta.persistence.Id
    @GeneratedValue
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private DatabaseEntity database;
    private int type;
    private int idSys;
    private String country;
    private int sunrise;
    private int sunset;

    public SysEntity(WeatherJson weatherJson) {
        this.type = weatherJson.getSys().getType();
        this.idSys = weatherJson.getSys().getId();
        this.country = weatherJson.getSys().getCountry();
        this.sunrise = (int) weatherJson.getSys().getSunrise();
        this.sunset = (int) weatherJson.getSys().getSunset();
    }

    public SysEntity() {

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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getIdSys() {
        return idSys;
    }

    public void setIdSys(int idSys) {
        this.idSys = idSys;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getSunrise() {
        return sunrise;
    }

    public void setSunrise(int sunrise) {
        this.sunrise = sunrise;
    }

    public int getSunset() {
        return sunset;
    }

    public void setSunset(int sunset) {
        this.sunset = sunset;
    }
}
