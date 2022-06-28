package org.mikedahl.fishingdiary.services;

import org.mikedahl.fishingdiary.models.Weather;

import java.util.List;


public interface WeatherService {

    List<Weather> getAllWeather();

    Weather saveWeather(Weather weather);

    Weather getWeatherById(Integer id);

    Weather updateWeather(Weather weather);

    void deleteWeatherById(Integer id);
}
