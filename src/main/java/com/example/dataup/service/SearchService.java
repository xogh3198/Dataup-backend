package com.example.dataup.service;

import com.example.dataup.dto.SearchResponseDto;
import com.example.dataup.entity.RouteData;
import com.example.dataup.repository.RouteDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SearchService {

    private final RouteDataRepository routeDataRepository;

    /**
     * PRD 요구사항에 따라 경로 정보를 계산합니다.
     */
    public SearchResponseDto calculateRoute(String start, String end) {

        // 1. DB 조회
        RouteData routeData = routeDataRepository.findByDestinationName(end)
                .orElseThrow(() -> new RuntimeException("경로 정보를 찾을 수 없습니다: " + end));

        SearchResponseDto dto = new SearchResponseDto();
        dto.setDestination(routeData.getDestinationName());

        // [수정 포인트]
        // 기존: getLastTrainTime() (삭제됨)
        // 변경: getLatestDepartureTime() (모델링에서 계산한 출발 데드라인 사용)
        LocalDateTime latestDeparture = routeData.getLatestDepartureTime();

        // 2. 시간 설정
        // (1) 막차 시간 표시: 사용자가 '언제 출발해야 하는지'가 중요하므로 데드라인을 보여줍니다.
        dto.setLastTrainTime(latestDeparture);

        // (2) 권장 출발 시간: 데드라인보다 15분 일찍 출발하도록 제안
        dto.setRecommendedDepartureTime(latestDeparture.minusMinutes(15));

        // (3) 최대 출발 가능 시간
        dto.setLatestDepartureTime(latestDeparture);

        // 3. 나머지 정보 설정
        dto.setTotalDuration(routeData.getAvgTravelTimeMinutes() + "분");
        dto.setTransferInfo(routeData.getTransferInfo());
        dto.setWalkingDistance(routeData.getWalkingDistance());
        dto.setSafetyScore(routeData.getSafetyScore());

        return dto;
    }
}