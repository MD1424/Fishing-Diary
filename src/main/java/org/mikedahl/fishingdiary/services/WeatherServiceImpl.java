package org.mikedahl.fishingdiary.services;

import org.mikedahl.fishingdiary.repositories.WeatherRepository;
import org.springframework.stereotype.Service;
import org.mikedahl.fishingdiary.models.Weather;


import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {

    private WeatherRepository weatherRepository;

    public WeatherServiceImpl(WeatherRepository weatherRepository) {
        super();
        this.weatherRepository = weatherRepository;
    }

    @Override
    public List<Weather> getAllWeather() {
        return weatherRepository.findAll();
    }

    @Override
    public Weather saveWeather(Weather weather) {
        Weather existingWeather = weatherRepository.findByWeatherType(weather.getWeatherType());
        if (existingWeather == null){
            return weatherRepository.save(weather);
        }

        return existingWeather;
    }

    @Override
    public Weather getWeatherById(Integer id) {
        return weatherRepository.findById(id).get();
    }

    @Override
    public Weather updateWeather(Weather weather) {
        return weatherRepository.save(weather);
    }

    @Override
    public void deleteWeatherById(Integer id) {
        weatherRepository.deleteById(id);
    }
}
