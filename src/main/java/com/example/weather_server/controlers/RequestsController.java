package com.example.weather_server.controlers;

import com.example.weather_server.json_weather.Sys;
import com.example.weather_server.json_weather.WeatherJson;
import com.example.weather_server.json_weather.Wind;
import com.example.weather_server.repos.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
public class RequestsController {
    @Autowired
    private CloudsRepository cloudsRepository;
    @Autowired
    private CoordRepository coordRepository;
    @Autowired
    private DatabaseRepository databaseRepository;
    @Autowired
    private MainRepository mainRepository;
    @Autowired
    private SysRepository sysRepository;
    @Autowired
    private WeatherRepository weatherRepository;
    @Autowired
    private WindRepository windRepository;

    @GetMapping("/updateWeather/{id}/{lon}/{lat}")
    @ResponseBody
    public WeatherJson updateWeaher(@PathVariable("id") Long id, @PathVariable("lon") Double lon, @PathVariable("lat") Double lat) {
        String url = "https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=" + "20c29eec2e1c9d4891b32fac6a783bde" + "&units=metric";
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
            databaseRepository.save(new com.example.weather_server.database.DatabaseEntity(id, weatherJson.getBase(), weatherJson.getVisibility(), weatherJson.getDt(), weatherJson.getTimezone(), weatherJson.getName(), weatherJson.getCod(), weatherJson.getId()));
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

