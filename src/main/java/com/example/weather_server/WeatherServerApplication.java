package com.example.weather_server;

import com.example.weather_server.database.WindEntity;
import com.example.weather_server.json_weather.WeatherJson;
import com.example.weather_server.repos.WindRepository;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@Controller
@SpringBootApplication
public class WeatherServerApplication {
	Log log = LogFactory.getLog(WeatherServerApplication.class);
	@Autowired
	private WindRepository windRepository;
	@PostMapping("/wind")
	public void wind(@RequestBody WeatherJson weather){
		windRepository.save(new WindEntity(weather));
		windRepository.findAll().forEach(log::info);
	}

	public static void main(String[] args) {
		SpringApplication.run(WeatherServerApplication.class, args);
	}

}
