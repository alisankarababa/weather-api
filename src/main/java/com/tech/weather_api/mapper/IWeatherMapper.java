package com.tech.weather_api.mapper;


import com.tech.weather_api.dto.*;
import com.tech.weather_api.exception.OpenMeteoException;
import com.tech.weather_api.exception.eExceptionMessage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IWeatherMapper {

    IWeatherMapper INSTANCE = Mappers.getMapper(IWeatherMapper.class);



    @Mapping(target = "country", source = "geoLocationResultDto.country")
    @Mapping(target = "name", source = "geoLocationResultDto.name")
    @Mapping(target = "latitude", source = "weatherDto.latitude")
    @Mapping(target = "longitude", source = "weatherDto.longitude")
    @Mapping(target = "temperatureNow", source = "weatherDto.current.temperature_2m")
    @Mapping(target = "temperatureMax", expression = "java( weatherDto.daily().temperature_2m_max().get(0) )")
    @Mapping(target = "temperatureMin", expression = "java( weatherDto.daily().temperature_2m_min().get(0) )")
    WeatherTodayDto weatherDtoToWeatherTodayDto(WeatherDto weatherDto, GeoLocationResultDto geoLocationResultDto);

    @Mapping(target = "country", source = "geoLocationResultDto.country")
    @Mapping(target = "name", source = "geoLocationResultDto.name")
    @Mapping(target = "latitude", source = "weatherDto.latitude")
    @Mapping(target = "longitude", source = "weatherDto.longitude")
    @Mapping(target = "forecastList", expression = "java( mapDailyToForecastList(weatherDto) )")
    WeatherMultiDaysDto weatherDtoToWeatherMultiDaysDto(WeatherDto weatherDto, GeoLocationResultDto geoLocationResultDto);


    default List<WeatherTimeTmaxTminDto> mapDailyToForecastList(WeatherDto weatherDto) {
        List<WeatherTimeTmaxTminDto> forecastList = new ArrayList<>();
        List<String> time = weatherDto.daily().time();
        List<Double> temperatureMax = weatherDto.daily().temperature_2m_max();
        List<Double> temperatureMin = weatherDto.daily().temperature_2m_min();

        if (!(time.size() == temperatureMax.size() && time.size() == temperatureMin.size())) {
            throw new OpenMeteoException(eExceptionMessage.OPEN_METEO_ARRAY_SIZE_MISMATCH);
        }

        for (int i = 0; i < time.size(); i++) {
            WeatherTimeTmaxTminDto dto = new WeatherTimeTmaxTminDto(time.get(i), temperatureMax.get(i), temperatureMin.get(i) );
            forecastList.add(dto);
        }

        return forecastList;
    }
}
