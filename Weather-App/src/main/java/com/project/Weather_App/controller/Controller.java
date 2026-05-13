package com.project.Weather_App.controller;

import com.project.Weather_App.Service.WeatherService;
import com.project.Weather_App.dto.WeatherForecast;
import com.project.Weather_App.dto.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
// @RestController = @Controller + @ResponseBody
// Means: har method ka return value direct JSON response banega
@RequestMapping("/weather")
// Base URL for this controller → /weather
@CrossOrigin
public class Controller {

    // WeatherService ka object Spring automatically inject karega
    @Autowired
    private WeatherService service;

    /*
     * Simple test API
     * URL: /weather/{city}
     * Example: /weather/delhi
     */
    @GetMapping("/{city}")
    public String getWeatherData(@PathVariable String city) {

        // Abhi city use nahi ho rahi
        // Sirf service ka test method call ho raha hai
        return service.test();
    }

    /*
     * OLD VERSION (commented)
     * Isme direct Root object return hota tha
     * Jo external API ka complete response deta
     */

    /*
    @GetMapping("/my/{city}")
    public Root getWeather(@PathVariable String city) {
        return service.getData(city);
    }
    */

    /*
     * Get CURRENT weather data for a city
     * URL: /weather/my/{city}
     * Example: /weather/my/mumbai
     *
     * Response: Custom WeatherResponse object
     * (Only required fields like city, temp, condition)
     */
    @GetMapping("/my/{city}")
    public WeatherResponse getWeather(@PathVariable String city) {

        // Controller → Service call
        // Service external Weather API ko call karega
        return service.getData(city);
    }

    /*
     * Get WEATHER FORECAST
     * URL: /weather/forecast?city=delhi&days=3
     *
     * @RequestParam is used for query parameters
     */
    @GetMapping("/forecast")
    public WeatherForecast getForecast(
            @RequestParam String city,
            @RequestParam int days) {

        // Forecast data service se fetch karna
        return service.getForecast(city, days);
    }
}
