package com.tech.weather_api.exception;

import org.springframework.http.HttpStatus;

public class LocationNotFoundException extends WeatherApiException {

    public LocationNotFoundException() {
        super(eExceptionMessage.LOCATION_NOT_FOUND, HttpStatus.NOT_FOUND);
    }
}
