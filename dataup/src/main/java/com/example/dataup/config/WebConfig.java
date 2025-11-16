package com.example.dataup.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * CORS (Cross-Origin Resource Sharing) 설정
 * React Native 앱에서 백엔드 API를 호출할 수 있도록 허용
 */
@Configuration
public class WebConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        
        // 모든 출처에서의 요청 허용 (개발 환경용)
        config.addAllowedOriginPattern("*");
        
        // 모든 HTTP 메서드 허용
        config.addAllowedMethod("*");
        
        // 모든 헤더 허용
        config.addAllowedHeader("*");
        
        // 인증 정보 허용
        config.setAllowCredentials(true);
        
        // preflight 요청 캐시 시간 (초)
        config.setMaxAge(3600L);
        
        source.registerCorsConfiguration("/api/**", config);
        return new CorsFilter(source);
    }
}

