package com.tech.weather_api.dto;

public record WeatherTodayDto(
        String country,
        String name,
        Double latitude,
        Double longitude,
        Double temperatureNow,
        Double temperatureMax,
        Double temperatureMin) {
}
