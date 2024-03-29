﻿# weather-api

this is an app using two external APIs:
  - https://api.open-meteo.com/v1/forecast
  - https://geocoding-api.open-meteo.com/v1/search
to find out forecast information about the location user asked for

## Endpoints
- http://localhost:8080/weather/api/forecast/today
- http://localhost:8080/weather/api/forecast/one-week
- http://localhost:8080/weather/api/forecast/two-weeks

Each endpoint requires request parameter location, which can be a city name or a country name

## Response

Response of each endpoint called with location=istanbul are given below

- today
```json
{
    "data": {
        "country": "Turkey",
        "name": "Istanbul",
        "latitude": 41.0,
        "longitude": 28.9375,
        "temperatureNow": 9.6,
        "temperatureMax": 11.9,
        "temperatureMin": 4.5
    },
    "time": "2024-03-07T18:46:44.8255608",
    "success": true
 }
```
- one-week
```json
   {
    "data": {
        "country": "Turkey",
        "name": "Istanbul",
        "latitude": 41.0,
        "longitude": 28.9375,
        "forecastList": [
            {
                "date": "2024-03-07",
                "temperatureMax": 11.9,
                "temperatureMin": 4.5
            },
            {
                "date": "2024-03-08",
                "temperatureMax": 9.4,
                "temperatureMin": 7.2
            },
            {
                "date": "2024-03-09",
                "temperatureMax": 10.2,
                "temperatureMin": 5.2
            },
            {
                "date": "2024-03-10",
                "temperatureMax": 12.0,
                "temperatureMin": 3.7
            },
            {
                "date": "2024-03-11",
                "temperatureMax": 15.3,
                "temperatureMin": 7.0
            },
            {
                "date": "2024-03-12",
                "temperatureMax": 20.5,
                "temperatureMin": 11.1
            },
            {
                "date": "2024-03-13",
                "temperatureMax": 15.8,
                "temperatureMin": 10.9
            }
        ]
    },
    "time": "2024-03-07T18:48:28.744742",
    "success": true
}
```

- two-weeks
```json
{
    "data": {
        "country": "Turkey",
        "name": "Istanbul",
        "latitude": 41.0,
        "longitude": 28.9375,
        "forecastList": [
            {
                "date": "2024-03-07",
                "temperatureMax": 11.9,
                "temperatureMin": 4.5
            },
            {
                "date": "2024-03-08",
                "temperatureMax": 9.4,
                "temperatureMin": 7.2
            },
            {
                "date": "2024-03-09",
                "temperatureMax": 10.2,
                "temperatureMin": 5.2
            },
            {
                "date": "2024-03-10",
                "temperatureMax": 12.0,
                "temperatureMin": 3.7
            },
            {
                "date": "2024-03-11",
                "temperatureMax": 15.3,
                "temperatureMin": 7.0
            },
            {
                "date": "2024-03-12",
                "temperatureMax": 20.5,
                "temperatureMin": 11.1
            },
            {
                "date": "2024-03-13",
                "temperatureMax": 15.8,
                "temperatureMin": 10.9
            },
            {
                "date": "2024-03-14",
                "temperatureMax": 13.9,
                "temperatureMin": 9.7
            },
            {
                "date": "2024-03-15",
                "temperatureMax": 15.8,
                "temperatureMin": 9.2
            },
            {
                "date": "2024-03-16",
                "temperatureMax": 18.0,
                "temperatureMin": 11.9
            },
            {
                "date": "2024-03-17",
                "temperatureMax": 15.5,
                "temperatureMin": 12.6
            },
            {
                "date": "2024-03-18",
                "temperatureMax": 12.7,
                "temperatureMin": 9.5
            },
            {
                "date": "2024-03-19",
                "temperatureMax": 16.3,
                "temperatureMin": 9.1
            },
            {
                "date": "2024-03-20",
                "temperatureMax": 18.6,
                "temperatureMin": 10.2
            }
        ]
    },
    "time": "2024-03-07T18:49:15.7869163",
    "success": true
}
```
