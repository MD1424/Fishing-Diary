package org.mikedahl.fishingdiary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.mikedahl.fishingdiary.models.Weather;



public interface WeatherRepository extends JpaRepository<Weather, Integer> {
    public Weather findByWeatherType(String weatherType);
}

