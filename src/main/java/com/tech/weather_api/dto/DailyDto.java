package com.tech.weather_api.dto;


import java.util.List;

public record DailyDto(List<String> time, List<Double> temperature_2m_max, List<Double> temperature_2m_min) {
}
