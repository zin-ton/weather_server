package com.example.weather_server.json_weather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Clouds {
    @JsonProperty("all")
    private Double all;

    public double getAll() {
        return all;
    }

    public void setAll(double all) {
        this.all = all;
    }
}
