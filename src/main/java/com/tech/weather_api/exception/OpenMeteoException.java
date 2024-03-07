package com.tech.weather_api.exception;

import org.springframework.http.HttpStatus;

public class OpenMeteoException extends WeatherApiException{

    public OpenMeteoException(IExceptionMessage exceptionMessage) {
        super(exceptionMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
