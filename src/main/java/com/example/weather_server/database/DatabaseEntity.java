package com.example.weather_server.database;

import com.example.weather_server.json_weather.WeatherJson;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.OneToOne;

@Entity
public class DatabaseEntity {
    @jakarta.persistence.Id
    @GeneratedValue
    private Long id;
    private Long userId;
    private Long visibility;
    private Long dt;
    private Long timezone;
    private String cityName;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "database")
    private CoordEntity coord;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "database")
    private MainEntity main;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "database")
    private WindEntity wind;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "database")
    private CloudsEntity cloudsEntity;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "database")
    private SysEntity sys;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "database")
    private WeatherEntity weather;

    public DatabaseEntity(WeatherJson weatherJson, Long user_id) {
        this.userId = user_id;
        this.visibility = (long) weatherJson.getVisibility();
        this.dt = weatherJson.getDateTime();
        this.timezone = weatherJson.getTimezone();
        this.cityName = weatherJson.getCityName();
    }

    public DatabaseEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getVisibility() {
        return visibility;
    }

    public void setVisibility(Long visibility) {
        this.visibility = visibility;
    }

    public Long getDt() {
        return dt;
    }

    public void setDt(Long dt) {
        this.dt = dt;
    }

    public Long getTimezone() {
        return timezone;
    }

    public void setTimezone(Long timezone) {
        this.timezone = timezone;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public CoordEntity getCoord() {
        return coord;
    }

    public void setCoord(CoordEntity coord) {
        this.coord = coord;
    }

    public MainEntity getMain() {
        return main;
    }

    public void setMain(MainEntity main) {
        this.main = main;
    }

    public WindEntity getWind() {
        return wind;
    }

    public void setWind(WindEntity wind) {
        this.wind = wind;
    }

    public CloudsEntity getClouds() {
        return cloudsEntity;
    }

    public void setClouds(CloudsEntity cloudsEntity) {
        this.cloudsEntity = cloudsEntity;
    }

    public SysEntity getSys() {
        return sys;
    }

    public void setSys(SysEntity sys) {
        this.sys = sys;
    }

    public WeatherEntity getWeather() {
        return weather;
    }

    public void setWeather(WeatherEntity weather) {
        this.weather = weather;
    }
}
