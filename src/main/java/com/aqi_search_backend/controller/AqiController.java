package com.aqi_search_backend.controller;

import com.aqi_search_backend.dto.AqiResponseDto;
import com.aqi_search_backend.service.AqiService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/aqi")
@CrossOrigin("*")  // Allow requests from any frontend
public class AqiController {

    private final AqiService aqiService;

    public AqiController(AqiService aqiService) {
        this.aqiService = aqiService;
    }

    @GetMapping("/{city}")
    public AqiResponseDto getAqi(@PathVariable String city) {
        return aqiService.getAqiByCity(city);
    }
}
