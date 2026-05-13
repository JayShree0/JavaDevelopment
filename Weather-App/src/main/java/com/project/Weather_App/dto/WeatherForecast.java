package com.project.Weather_App.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({ "weatherResponse", "daysTemp" })
public class WeatherForecast {

    // Declare this FIRST
    private WeatherResponse weatherResponse;

    // Declare this SECOND
    private List<DaysTemp> daysTemp;

    public WeatherResponse getWeatherResponse() {
        return weatherResponse;
    }

    public void setWeatherResponse(WeatherResponse weatherResponse) {
        this.weatherResponse = weatherResponse;
    }

    public List<DaysTemp> getDaysTemp() {
        return daysTemp;
    }

    public void setDaysTemp(List<DaysTemp> daysTemp) {
        this.daysTemp = daysTemp;
    }
}
