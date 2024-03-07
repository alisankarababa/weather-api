package com.tech.weather_api.dto;

public record GeoLocationResultDto(
        String country,
        String name,
        double latitude,
        double longitude
) {
}
