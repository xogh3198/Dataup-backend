package com.example.dataup.repository;

import com.example.dataup.entity.RouteData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * RouteData Entity를 위한 JPA 리포지토리
 * (목적지 이름으로 경로 데이터를 찾는 메소드)
 */
@Repository
public interface RouteDataRepository extends JpaRepository<RouteData, Long> {
    
    // "destinationName" 필드를 기준으로 데이터를 검색합니다.
    Optional<RouteData> findByDestinationName(String destinationName);
}