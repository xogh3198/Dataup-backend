package com.example.dataup.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class RouteData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 검색 기준이 되는 목적지 이름
    @Column(unique = true)
    private String destinationName;

    // [핵심] 모델링에서 계산한 "인하대에서 출발해야 하는 시간"
    // 예: 22:50 (이때 안 나가면 중간에 끊김)
    private LocalDateTime latestDepartureTime;

    // 목적지에 도착하는 막차 시간 (UI 표시용, 로직엔 안 쓰임)
    // 예: 23:55 (강남역 도착 시간)
    private LocalDateTime lastTrainArrivalTime;

    // 총 소요 시간 (버스+전철+도보 합산)
    private int avgTravelTimeMinutes;

    private String transferInfo;
    private String walkingDistance;
    private int safetyScore;
}