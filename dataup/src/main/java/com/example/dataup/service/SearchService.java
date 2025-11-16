package com.example.dataup.service;

import com.example.dataup.dto.SearchResponseDto;
import com.example.dataup.entity.RouteData;
import com.example.dataup.repository.RouteDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor // final 필드에 대한 생성자 자동 주입
@Transactional(readOnly = true)
public class SearchService {

    private final RouteDataRepository routeDataRepository;

    /**
     * PRD 요구사항에 따라 경로 정보를 계산합니다.
     * @param start (현재는 사용되지 않으나 확장성 위해 포함)
     * @param end (목적지 이름)
     * @return SearchResponseDto (프론트엔드로 보낼 응답)
     */
    public SearchResponseDto calculateRoute(String start, String end) {
        
        // 1. DB에서 목적지 이름으로 경로 데이터 조회
        // (데이터가 없으면 RuntimeException 발생)
        RouteData routeData = routeDataRepository.findByDestinationName(end)
                .orElseThrow(() -> new RuntimeException("경로 정보를 찾을 수 없습니다: " + end));

        // 2. Entity -> DTO 변환 및 비즈니스 로직 적용
        SearchResponseDto dto = new SearchResponseDto();
        dto.setDestination(routeData.getDestinationName());

        LocalDateTime lastTrain = routeData.getLastTrainTime();
        int travelTime = routeData.getAvgTravelTimeMinutes();

        // 3. PRD 핵심 로직: 권장 출발 시간 계산
        // (막차 시간 - 총 소요 시간)
        LocalDateTime recommendedDeparture = lastTrain.minusMinutes(travelTime);

        dto.setLastTrainTime(lastTrain);
        dto.setRecommendedDepartureTime(recommendedDeparture);
        
        // PRD AC 1.2.4: "최대 늦춰도 출발 가능한 시간" (기획 의도 재확인 필요)
        // 여기서는 임시로 막차 시간과 동일하게 설정
        dto.setLatestDepartureTime(lastTrain); 
        
        dto.setTotalDuration(travelTime + "분"); // "75분"
        dto.setTransferInfo(routeData.getTransferInfo());
        dto.setWalkingDistance(routeData.getWalkingDistance());
        dto.setSafetyScore(routeData.getSafetyScore());

        return dto;
    }
}