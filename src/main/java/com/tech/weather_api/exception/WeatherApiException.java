package com.tech.weather_api.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class WeatherApiException extends RuntimeException{

    private final HttpStatus status;

    public WeatherApiException(IExceptionMessage exceptionMessage, HttpStatus status) {
        super(exceptionMessage.getMessage());
        this.status = status;
    }
}
