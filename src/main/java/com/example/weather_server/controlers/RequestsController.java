package com.example.weather_server.controlers;

import com.example.weather_server.database.DatabaseEntity;
import com.example.weather_server.json_weather.WeatherJson;
import com.example.weather_server.repos.DatabaseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
public class RequestsController {
    @Autowired
    private DatabaseRepository databaseRepository;

    @GetMapping("/updateWeather/{id}/{lon}/{lat}")
    @ResponseBody
    public WeatherJson updateWeaher(@PathVariable("id") Long id, @PathVariable("lon") Double lon, @PathVariable("lat") Double lat) {
        //TODO: add API key
        String url = "https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=" + "API" + "&units=metric";
        WeatherJson weatherJson = new WeatherJson();
        String answer = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            HttpURLConnection HttpURLConnection = (java.net.HttpURLConnection) new URL(url).openConnection();
            HttpURLConnection.setRequestMethod("GET");
            InputStream is = HttpURLConnection.getInputStream();
            HttpURLConnection.connect();
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            answer = new String(buffer);
            HttpURLConnection.disconnect();
            weatherJson = objectMapper.readValue(answer, WeatherJson.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (databaseRepository.findByUserId(id).size() == 0) {
            databaseRepository.save(new DatabaseEntity(weatherJson, id));
        } else {
            com.example.weather_server.database.DatabaseEntity databaseEntity = databaseRepository.findByUserId(id).get(0);
            databaseEntity.setVisibility((long) weatherJson.getVisibility());
            databaseEntity.setDt(weatherJson.getDt());
            databaseEntity.setTimezone(weatherJson.getTimezone());
            databaseEntity.setId(weatherJson.getId());
            databaseRepository.save(databaseEntity);
        }
        return weatherJson;
    }
}

