package com.example.dataup.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * DB 테이블과 매핑될 Entity 클래스.
 * Python 분석 스크립트가 이 구조에 맞춰 데이터를 PostgreSQL에 적재해야 합니다.
 */
@Entity
@Data
public class RouteData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String destinationName; // 목적지명 (예: "강남역")
    private LocalDateTime lastTrainTime; // 막차 시간 (ISO 8601)
    private int avgTravelTimeMinutes; // 평균 소요 시간 (분)
    private String transferInfo; // 환승 정보 (예: "9-1, 1호선")
    private String walkingDistance; // 도보 거리 (예: "580m")
    private int safetyScore; // 안전도 점수 (0-100)

}