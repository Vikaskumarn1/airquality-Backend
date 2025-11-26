package com.aqi_search_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication  // Marks this as the main Spring Boot app
@EnableCaching          // Enables caching for faster repeated responses
public class AqiSearchBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(AqiSearchBackendApplication.class, args);
        System.out.println("AQI Search Backend is running...");
    }
}
