package com.example.dataup.dto;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 프론트엔드(React Native)와 통신하기 위한 DTO (Data Transfer Object)
 * README.md의 API 응답 형식과 일치해야 합니다.
 */
@Data
public class SearchResponseDto {

    private String destination;
    private LocalDateTime lastTrainTime;
    private LocalDateTime recommendedDepartureTime;
    private LocalDateTime latestDepartureTime;
    private String totalDuration;
    private String transferInfo;
    private String walkingDistance;
    private int safetyScore;

}