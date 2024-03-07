package com.tech.weather_api.exception;

public enum eExceptionMessage implements IExceptionMessage{
    OPEN_METEO_ARRAY_SIZE_MISMATCH("Retreived forecast info has missing date, tMax, or tMin data"),
    LOCATION_NOT_FOUND("Location cannot be found");
    private final String message;
    eExceptionMessage(String message) {
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }
}
