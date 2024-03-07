package com.tech.weather_api.controller;

import com.tech.weather_api.client.IGeoLocationService;
import com.tech.weather_api.client.IWeatherService;
import com.tech.weather_api.dto.*;
import com.tech.weather_api.exception.LocationNotFoundException;
import com.tech.weather_api.mapper.IWeatherMapper;
import com.tech.weather_api.response.RestResponse;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/forecast")
@RequiredArgsConstructor
public class WeatherController {

    public static final String TEMPERATURE_MIN = "temperature_2m_min";
    public static final String TEMPERATURE_MAX = "temperature_2m_max";
    public static final String TEMPERATURE = "temperature_2m";


    private final IWeatherService weatherService;
    private final IGeoLocationService geoLocationService;

    @GetMapping("/one-week")
    public ResponseEntity<RestResponse<WeatherMultiDaysDto>> weeklyWeather(@Length(min = 2, message = "location must be at least two characters long") @RequestParam String location) {

        GeoLocationResultDto result = getFirstGeoLocationResultDto(location);
        WeatherDto weatherDto = getOneWeeksWeatherDto(result.latitude(), result.longitude());

        WeatherMultiDaysDto weatherMultiDaysDto = IWeatherMapper.INSTANCE.weatherDtoToWeatherMultiDaysDto(weatherDto, result);

        return ResponseEntity.ok(RestResponse.ok(weatherMultiDaysDto));
    }

    @GetMapping("/today")
    public ResponseEntity<RestResponse<WeatherTodayDto>> dailyWeather(@Length(min = 2, message = "location must be at least two characters long") @RequestParam String location) {

        GeoLocationResultDto result = getFirstGeoLocationResultDto(location);
        WeatherDto weatherDto = getTodaysWeatherDto(result.latitude(), result.longitude());

        WeatherTodayDto weatherTodayDto = IWeatherMapper.INSTANCE.weatherDtoToWeatherTodayDto(weatherDto, result);
        return ResponseEntity.ok(RestResponse.ok(weatherTodayDto));
    }

    @GetMapping("/two-weeks")
    public ResponseEntity<RestResponse<WeatherMultiDaysDto>> twoWeeksWeather(@Length(min = 2, message = "location must be at least two characters long") @RequestParam String location) {

        GeoLocationResultDto result = getFirstGeoLocationResultDto(location);
        WeatherDto weatherDto = getTwoWeeksWeatherDto(result.latitude(), result.longitude());

        WeatherMultiDaysDto weatherMultiDaysDto = IWeatherMapper.INSTANCE.weatherDtoToWeatherMultiDaysDto(weatherDto, result);

        return ResponseEntity.ok(RestResponse.ok(weatherMultiDaysDto));
    }

    private GeoLocationResultDto getFirstGeoLocationResultDto(String location) {
        GeoLocationDto geoLocationDto = geoLocationService.getData(location, Optional.of(1));
        List<GeoLocationResultDto> results = geoLocationDto.results();

        if(results == null) {
            throw new LocationNotFoundException();
        }

        return results.getFirst();
    }

    private WeatherDto getTwoWeeksWeatherDto(double latitude, double longitude) {

        return weatherService.getWeather(
                latitude,
                longitude,
                Optional.of(14),
                Optional.of(TEMPERATURE_MAX + "," + TEMPERATURE_MIN),
                Optional.empty()
        );
    }

    private WeatherDto getOneWeeksWeatherDto(double latitude, double longitude) {

        return weatherService.getWeather(
                latitude,
                longitude,
                Optional.of(7),
                Optional.of(TEMPERATURE_MAX + "," + TEMPERATURE_MIN),
                Optional.empty()
        );
    }

    private WeatherDto getTodaysWeatherDto(double latitude, double longitude) {

        return weatherService.getWeather(
                latitude,
                longitude,
                Optional.of(1),
                Optional.of(TEMPERATURE_MAX + ",temperature_2m_min"),
                Optional.of(TEMPERATURE)
        );
    }
}