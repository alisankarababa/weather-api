package com.tech.weather_api.dto;

import java.util.List;

public record GeoLocationDto(List<GeoLocationResultDto> results) {
}
