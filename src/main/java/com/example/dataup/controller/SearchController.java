package com.example.dataup.controller;

import com.example.dataup.dto.SearchResponseDto;
import com.example.dataup.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api") // /api 로 시작하는 모든 요청을 처리
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    /**
     * PRD P0: 경로 검색 API 엔드포인트
     * GET /api/search?start=인하대학교&end=강남역
     */
    @GetMapping("/search")
    public ResponseEntity<SearchResponseDto> searchRoute(
            @RequestParam("start") String start,
            @RequestParam("end") String end) {
        
        // SearchService에 비즈니스 로직 위임
        SearchResponseDto responseDto = searchService.calculateRoute(start, end);
        
        // 계산된 DTO를 JSON 형태로 반환
        return ResponseEntity.ok(responseDto);
    }
}