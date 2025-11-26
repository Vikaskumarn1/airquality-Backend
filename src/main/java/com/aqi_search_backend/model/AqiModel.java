package com.aqi_search_backend.model;


import lombok.Data;

@Data
public class AqiModel {

    private String cityName;
    private int aqi;
    private String dominantPollutant;
    private String lastUpdated;
    private double latitude;
    private double longitude;

}
