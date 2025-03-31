package com.example.procesador_pago;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Permitir solicitudes desde cualquier origen durante el desarrollo
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:3000"); // Puerto predeterminado en Flutter web
        config.addAllowedOrigin("http://localhost:8000"); // Otro puerto común
        config.addAllowedOrigin("http://localhost:9000"); // Por si usas otro puerto
        config.addAllowedOrigin("http://localhost:5000"); // Por si usas otro puerto
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}