-- [중요] 테이블 생성은 Hibernate가 자동으로 처리하므로 INSERT문만 작성합니다.
-- 컬럼명: latest_departure_time (인하대에서 출발해야 하는 마지노선 시간)

-- 1. 서울 주요 지역 (환승 및 이동 시간 고려하여 계산된 출발 데드라인)
INSERT INTO route_data (destination_name, latest_departure_time, avg_travel_time_minutes, transfer_info, walking_distance, safety_score)
VALUES ('강남역', '2025-11-20T22:50:00', 85, '9200번 → 2호선', '450m', 92);

INSERT INTO route_data (destination_name, latest_departure_time, avg_travel_time_minutes, transfer_info, walking_distance, safety_score)
VALUES ('홍대입구역', '2025-11-20T23:10:00', 75, '1601번 → 2호선', '300m', 85);

INSERT INTO route_data (destination_name, latest_departure_time, avg_travel_time_minutes, transfer_info, walking_distance, safety_score)
VALUES ('서울역', '2025-11-20T23:00:00', 80, '1호선 급행', '200m', 88);

INSERT INTO route_data (destination_name, latest_departure_time, avg_travel_time_minutes, transfer_info, walking_distance, safety_score)
VALUES ('신촌역', '2025-11-20T23:05:00', 78, '1601번 → 2호선', '400m', 75);

INSERT INTO route_data (destination_name, latest_departure_time, avg_travel_time_minutes, transfer_info, walking_distance, safety_score)
VALUES ('고속터미널역', '2025-11-20T22:45:00', 90, '9200번 → 3호선', '550m', 90);


-- 2. 인천/경기 주요 지역 (인하대 근처 및 번화가)
INSERT INTO route_data (destination_name, latest_departure_time, avg_travel_time_minutes, transfer_info, walking_distance, safety_score)
VALUES ('부평역', '2025-11-20T23:50:00', 35, '수인분당선 → 1호선', '150m', 65);

INSERT INTO route_data (destination_name, latest_departure_time, avg_travel_time_minutes, transfer_info, walking_distance, safety_score)
VALUES ('송도센트럴파크', '2025-11-21T00:00:00', 40, '인하대역 → 인천1호선', '600m', 95);

INSERT INTO route_data (destination_name, latest_departure_time, avg_travel_time_minutes, transfer_info, walking_distance, safety_score)
VALUES ('인천터미널', '2025-11-21T00:10:00', 30, '111-2번 버스', '100m', 80);

INSERT INTO route_data (destination_name, latest_departure_time, avg_travel_time_minutes, transfer_info, walking_distance, safety_score)
VALUES ('주안역', '2025-11-21T00:30:00', 20, '511번 버스', '50m', 70);

INSERT INTO route_data (destination_name, latest_departure_time, avg_travel_time_minutes, transfer_info, walking_distance, safety_score)
VALUES ('김포공항', '2025-11-20T23:15:00', 65, '공항철도 환승', '700m', 88);

INSERT INTO route_data (destination_name, latest_departure_time, avg_travel_time_minutes, transfer_info, walking_distance, safety_score)
VALUES ('수원역', '2025-11-20T23:00:00', 60, '수인분당선 직통', '250m', 82);