package com.aqi_search_backend.dto;

public class AqiResponseDto {

    private int aqi;
    private String dominentpol;
    private String city;
    private String time;
    private double latitude;
    private double longitude;

    public int getAqi() { return aqi; }
    public void setAqi(int aqi) { this.aqi = aqi; }

    public String getDominentpol() { return dominentpol; }
    public void setDominentpol(String dominentpol) { this.dominentpol = dominentpol; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }
}
