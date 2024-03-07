package com.tech.weather_api.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class RestResponse<T> {

    private T data;
    private LocalDateTime time;
    private boolean isSuccess;

    private RestResponse(T data, boolean isSuccess) {
        this.data = data;
        this.isSuccess = isSuccess;
        this.time = LocalDateTime.now();
    }

    public static <T> RestResponse<T> ok(T data) {

        return new RestResponse<>(data, true);
    }

    public static <T> RestResponse<T> error(T error) {

        return new RestResponse<>(error, false);
    }
}
