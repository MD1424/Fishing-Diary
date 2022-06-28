package org.mikedahl.fishingdiary.models;

import javax.persistence.*;

@Entity(name = "weather")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "weather_type")
    private String weatherType;


    public Weather(String weatherType) {
        this.weatherType = weatherType;
    }

    public Weather() {

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWeatherType() {
        return weatherType;
    }

    public void setWeatherType(String weatherType) {
        this.weatherType = weatherType;
    }


    public String getWeatherName() {
        String Weather = new String();
        return Weather;
    }
}
