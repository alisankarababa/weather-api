package com.tech.weather_api.dto;

public record WeatherDto(Double latitude, Double longitude, DailyDto daily, CurrentDto current) {
}
