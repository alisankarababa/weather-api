package com.tech.weather_api.exception;

import com.tech.weather_api.response.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<RestResponse<ExceptionDTO>> hException(Exception exception, WebRequest webRequest) {

        ExceptionDTO exceptionDTO = getExceptionDTO(exception, webRequest);
        return new ResponseEntity<>(RestResponse.error(exceptionDTO), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler ResponseEntity<RestResponse<ExceptionDTO>> hWeatherApiException(WeatherApiException weatherApiException, WebRequest webRequest) {
        ExceptionDTO exceptionDTO = getExceptionDTO(weatherApiException, webRequest);

        return new ResponseEntity<>(RestResponse.error(exceptionDTO), weatherApiException.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<RestResponse<ExceptionDTO>> hMissingServletRequestParameterException(MissingServletRequestParameterException exception, WebRequest webRequest) {

        ExceptionDTO exceptionDTO = getExceptionDTO(exception, webRequest);
        return new ResponseEntity<>(RestResponse.error(exceptionDTO), HttpStatus.BAD_REQUEST);
    }

    private static ExceptionDTO getExceptionDTO(Exception exception, WebRequest webRequest) {
        String details = webRequest.getDescription(false);
        String message = exception.getMessage();

        return new ExceptionDTO(message, details);
    }
}
