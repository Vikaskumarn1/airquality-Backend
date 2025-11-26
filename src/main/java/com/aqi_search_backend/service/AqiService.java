package com.aqi_search_backend.service;

import com.aqi_search_backend.dto.AqiResponseDto;
import com.aqi_search_backend.exception.ExternalApiException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Service
public class AqiService {

    private final WebClient webClient;

    @Value("${aqicn.api.key}")
    private String apiKey;

    public AqiService(WebClient webClient) {
        this.webClient = webClient;
    }

    @Cacheable(value = "aqiCache", key = "#cityName")
    public AqiResponseDto getAqiByCity(String cityName) {

        Map<String, Object> apiResponse;

        try {
            apiResponse = webClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/feed/" + cityName + "/")
                            .queryParam("token", apiKey)
                            .build())
                    .retrieve()
                    .bodyToMono(Map.class)
                    .block();
        } catch (Exception e) {
            throw new ExternalApiException("Error calling AQI API: " + e.getMessage());
        }

        if (apiResponse == null || !"ok".equalsIgnoreCase((String) apiResponse.get("status"))) {
            throw new ExternalApiException("City not found or API error.");
        }

        Map data = (Map) apiResponse.get("data");
        Map city = (Map) data.get("city");
        Map time = (Map) data.get("time");
        List geo = (List) city.get("geo");

        
        AqiResponseDto dto = new AqiResponseDto();
        Object aqiValue = data.get("aqi");
        dto.setAqi(aqiValue instanceof Number ? ((Number) aqiValue).intValue() : 0);
        dto.setDominentpol((String) data.get("dominentpol"));
        dto.setCity((String) city.get("name"));
        dto.setTime((String) time.get("s"));
        dto.setLatitude(((Number) geo.get(0)).doubleValue());
        dto.setLongitude(((Number) geo.get(1)).doubleValue());

        return dto;
    }
}
