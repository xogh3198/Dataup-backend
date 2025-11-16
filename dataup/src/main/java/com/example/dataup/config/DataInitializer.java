package com.example.dataup.config;

import com.example.dataup.entity.RouteData;
import com.example.dataup.repository.RouteDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * H2 DB에 초기 테스트 데이터를 생성하는 클래스
 * (앱 실행 시 자동으로 동작)
 */
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final RouteDataRepository repository;

    @Override
    public void run(String... args) throws Exception {
        
        // 1. 강남역 테스트 데이터 (Figma 프로토타입 3 참고)
        RouteData data1 = new RouteData();
        data1.setDestinationName("강남역");
        data1.setLastTrainTime(LocalDateTime.parse("2025-11-11T22:40:00")); // 막차 22:40
        data1.setAvgTravelTimeMinutes(75); // 총 75분 소요
        data1.setTransferInfo("9-1, 1호선, 2호선");
        data1.setWalkingDistance("580m");
        data1.setSafetyScore(72); // 안전도 72점
        repository.save(data1);

        // 2. 홍대입구역 테스트 데이터 (안전도 70점 미만)
        RouteData data2 = new RouteData();
        data2.setDestinationName("홍대입구역");
        data2.setLastTrainTime(LocalDateTime.parse("2025-11-11T23:00:00")); // 막차 23:00
        data2.setAvgTravelTimeMinutes(80); // 총 80분 소요
        data2.setTransferInfo("1호선, 2호선");
        data2.setWalkingDistance("420m");
        data2.setSafetyScore(65); // 안전도 65점 (위험 경고)
        repository.save(data2);
    }
}