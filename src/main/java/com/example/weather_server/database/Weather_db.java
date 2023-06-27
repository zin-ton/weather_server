package com.example.weather_server.database;

import com.example.weather_server.json_weather.Weather_json;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import org.springframework.data.annotation.Id;

@Entity
public class Weather_db {
    private @Id @GeneratedValue Long id;
    private Double coord_lon;
    private Double coord_lat;
    private String weather_main;
    private String weather_description;
    private Double main_temp;
    private Double main_feels_like;
    private Double main_temp_min;
    private Double main_temp_max;
    private Double main_pressure;
    private Double main_humidity;
    private Double visibility;
    private Double wind_speed;
    private Integer wind_deg;
    private Double clouds_all;
    private Long dt;
    private String sys_country;
    private Long sys_sunrise;
    private Long sys_sunset;
    private Long timezone;
    private String city_name;
    Weather_db(Weather_json weather){
        this.coord_lon = weather.getCoordinates().getLongitude();
        this.coord_lat = weather.getCoordinates().getLatitude();
        this.weather_main = weather.getWeather()[0].getMain();
        this.weather_description = weather.getWeather()[0].getDescription();
        this.main_temp = weather.getMain().getTemperature();
        this.main_feels_like = weather.getMain().getFeelsLike();
        this.main_temp_min = weather.getMain().getMinTemperature();
        this.main_temp_max = weather.getMain().getMaxTemperature();
        this.main_pressure = weather.getMain().getPressure();
        this.main_humidity = weather.getMain().getHumidity();
        this.visibility = weather.getVisibility();
        this.wind_speed = weather.getWind().getSpeed();
        this.wind_deg = weather.getWind().getDirection();
        this.clouds_all = weather.getClouds().getAll();
        this.dt = weather.getDateTime();
        this.sys_country = weather.getSys().getCountry();
        this.sys_sunrise = weather.getSys().getSunrise();
        this.sys_sunset = weather.getSys().getSunset();
        this.timezone = weather.getTimezone();
        this.city_name = weather.getCityName();
    }

    public Double getCoord_lon() {
        return coord_lon;
    }

    public void setCoord_lon(Weather_json weather) {
        this.coord_lon = weather.getCoordinates().getLongitude();
    }

    public Double getCoord_lat() {
        return coord_lat;
    }

    public void setCoord_lat(Weather_json weather) {
        this.coord_lat = weather.getCoordinates().getLatitude();
    }

    public String getWeather_main() {
        return weather_main;
    }

    public void setWeather_main(Weather_json weather) {
        this.weather_main = weather.getWeather()[0].getMain();
    }

    public String getWeather_description() {
        return weather_description;
    }

    public void setWeather_description(Weather_json weather) {
        this.weather_description = weather.getWeather()[0].getDescription();
    }

    public Double getMain_temp() {
        return main_temp;
    }

    public void setMain_temp(Weather_json weather) {
        this.main_temp = weather.getMain().getTemperature();
    }

    public Double getMain_feels_like() {
        return main_feels_like;
    }

    public void setMain_feels_like(Weather_json weather) {
        this.main_feels_like = weather.getMain().getFeelsLike();
    }

    public Double getMain_temp_min() {
        return main_temp_min;
    }

    public void setMain_temp_min(Weather_json weather) {
        this.main_temp_min = weather.getMain().getMinTemperature();
    }

    public Double getMain_temp_max() {
        return main_temp_max;
    }

    public void setMain_temp_max(Weather_json weather) {
        this.main_temp_max = weather.getMain().getMaxTemperature();
    }

    public Double getMain_pressure() {
        return main_pressure;
    }

    public void setMain_pressure(Weather_json weather) {
        this.main_pressure = weather.getMain().getPressure();

    }

    public Double getMain_humidity() {
        return main_humidity;
    }

    public void setMain_humidity(Weather_json weather) {
        this.main_humidity = weather.getMain().getHumidity();
    }

    public Double getVisibility() {
        return visibility;
    }

    public void setVisibility(Weather_json weather) {
        this.visibility = weather.getVisibility();
    }

    public Double getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(Weather_json weather) {
        this.wind_speed = weather.getWind().getSpeed();
    }

    public Integer getWind_deg() {
        return wind_deg;
    }

    public void setWind_deg(Weather_json weather) {
        this.wind_deg = weather.getWind().getDirection();
    }

    public Double getClouds_all() {
        return clouds_all;
    }

    public void setClouds_all(Weather_json weather) {
        this.clouds_all = weather.getClouds().getAll();
    }

    public Long getDt() {
        return dt;
    }

    public void setDt(Weather_json weather) {
        this.dt = weather.getDateTime();
    }

    public String getSys_country() {
        return sys_country;
    }

    public void setSys_country(Weather_json weather) {
        this.sys_country = weather.getSys().getCountry();
    }

    public Long getSys_sunrise() {
        return sys_sunrise;
    }

    public void setSys_sunrise(Weather_json weather) {
        this.sys_sunrise = weather.getSys().getSunrise();
    }

    public Long getSys_sunset() {
        return sys_sunset;
    }

    public void setSys_sunset(Weather_json weather) {
        this.sys_sunset = weather.getSys().getSunset();
    }

    public Long getTimezone() {
        return timezone;
    }

    public void setTimezone(Weather_json weather) {
        this.timezone = weather.getTimezone();
    }

    public String getName() {
        return name;
    }

    public void setName(Weather_json weather) {
        this.city_name = weather.getCityName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
