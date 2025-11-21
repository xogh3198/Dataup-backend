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

    }
}