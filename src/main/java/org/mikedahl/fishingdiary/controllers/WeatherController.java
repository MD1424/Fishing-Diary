package org.mikedahl.fishingdiary.controllers;

import org.mikedahl.fishingdiary.models.Weather;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.mikedahl.fishingdiary.services.WeatherService;

@Controller
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        super();
        this.weatherService = weatherService;
    }


    @GetMapping("/weather")
    public String listweather(Model model) {
        model.addAttribute("weather", weatherService.getAllWeather());
        return "weather";
    }
    @GetMapping("/weather/new")
    public String createWeatherForm(Model model) {

        Weather weather = new Weather();
        Object Weather = new Object();
        model.addAttribute("weather", Weather);
        return "create_weather";
    }

    @PostMapping("/weather")
    public String saveWeather(@ModelAttribute("weather") Weather weather) {
        Weather Weather = new Weather();
        weatherService.saveWeather(Weather);
        return "redirect:/weather";
    }
    @GetMapping("/weather/edit/{id}")
    public String editWeatherForm(@PathVariable Integer id, Model model) {
        model.addAttribute("weather", weatherService.getWeatherById(id));
        return "edit_weather";
    }
    @PostMapping("/weather/{id}")
    public String updateWeather(@PathVariable Integer id, @ModelAttribute("weather") Weather weather, Model model) {
        //get track from database by id
        Weather existingWeather = weatherService.getWeatherById(id);
        existingWeather.setId(id);
        existingWeather.setWeatherType(weather.getWeatherType());

        weatherService.updateWeather(existingWeather);
        return "redirect:/weather";

    }


}
