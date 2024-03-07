package com.tech.weather_api.dto;

import java.util.List;

public record WeatherMultiDaysDto(
        String country,
        String name,
        Double latitude,
        Double longitude,
        List<WeatherTimeTmaxTminDto> forecastList) {
}
