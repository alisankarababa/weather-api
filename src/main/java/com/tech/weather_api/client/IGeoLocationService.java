package com.tech.weather_api.client;

import com.tech.weather_api.dto.GeoLocationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@FeignClient(name = "geo-location-service", url = "https://geocoding-api.open-meteo.com/v1/search")
public interface IGeoLocationService {


    @GetMapping
    GeoLocationDto getData(
            @RequestParam String name,
            @RequestParam Optional<Integer> count
    );
}
