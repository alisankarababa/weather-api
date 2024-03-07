package com.tech.weather_api.dto;

public record WeatherTimeTmaxTminDto(
        String date,
        double temperatureMax,
        double temperatureMin
) {
}
