package com.tech.weather_api.client;

import com.tech.weather_api.dto.WeatherDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@FeignClient(name = "weather-service", url = "https://api.open-meteo.com/v1/forecast")
public interface IWeatherService {

    @GetMapping
    WeatherDto getWeather(
            @RequestParam double latitude,
            @RequestParam double longitude,
            @RequestParam Optional<Integer> forecast_days,
            @RequestParam Optional<String> daily,
            @RequestParam Optional<String> current
    );
}
