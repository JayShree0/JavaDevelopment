package com.project.Weather_App.Service;

import com.project.Weather_App.dto.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service // Marks this class as a Spring Service (business logic layer)
public class WeatherService {

    // API key read from application.properties / application.yml
    @Value("${weather.api.key}")
    private String apiKey;

    // Current weather API URL
    @Value("${weather.api.url}")
    private String apiUrl;

    // Forecast weather API URL
    @Value("${weather.api.forecast.url}")
    private String apiForecastUrl;

    // Simple test method to check service is working
    public String test() {
        return "good weather";
    }

    /*
     * RestTemplate is used to consume external APIs
     * Matlab: hum apne Spring Boot application se
     * kisi dusre backend (Weather API) ko call kar rahe hain
     */
    private RestTemplate template = new RestTemplate();

    /*
     * This method fetches CURRENT weather data for a city
     */
    public WeatherResponse getData(String city) {

        // API URL with query parameters
        // ?key=API_KEY&q=city_name
        String url = apiUrl + "?key=" + apiKey + "&q=" + city;

        /*
         * getForObject():
         * 1. URL pe request bhejta hai
         * 2. JSON response ko Root class me convert karta hai
         */
        Root response = template.getForObject(url, Root.class);

        // Custom response object (only required fields)
        WeatherResponse weatherResponse = new WeatherResponse();

        // Location details
        weatherResponse.setCity(response.getLocation().name);
        weatherResponse.setRegion(response.getLocation().region);
        weatherResponse.setCountry(response.getLocation().country);

        // Weather condition (Sunny, Cloudy, etc.)
        String condition = response.getCurrent().getCondition().getText();
        weatherResponse.setCondition(condition);

        // Temperature in Celsius
        weatherResponse.setTemperature(response.getCurrent().getTemp_c());

        return weatherResponse;
    }

    /*
     * This method fetches WEATHER FORECAST for given days
     */
    public WeatherForecast getForecast(String city, int days) {

        // Fetch current weather first
        WeatherResponse weatherResponse = getData(city);

        // Final response object
        WeatherForecast response = new WeatherForecast();
        response.setWeatherResponse(weatherResponse);

        // Forecast API URL
        String url = apiForecastUrl + "?key=" + apiKey + "&q=" + city + "&days=" + days;

        // Calling forecast API
        Root apiResponse = template.getForObject(url, Root.class);

        // Extract forecast data
        Forecast forecast = apiResponse.getForecast();
        ArrayList<Forecastday> forecastday = forecast.getForecastday();

        // List to store temperature data of each day
        List<DaysTemp> dayList = new ArrayList<>();

        /*
         * Loop through each forecast day
         * and extract min, max, avg temperature
         */
        for (Forecastday rs : forecastday) {

            DaysTemp d = new DaysTemp();
            d.setDate(rs.getDate());
            d.setMinTemp(rs.getDay().mintemp_c);
            d.setMaxTemp(rs.getDay().maxtemp_c);
            d.setAvgTemp(rs.getDay().avgtemp_c);

            dayList.add(d);
        }

        // Set forecast list in response
        response.setDaysTemp(dayList);

        return response;
    }
}
