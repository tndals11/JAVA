package org.example.z_project.user_reservation.repository;

import org.example.z_project.user_reservation.entity.Reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReservationRepository {
    private final List<Reservation> reservations = new ArrayList<>();

    // 예약 등록(CREATE)
    // : DB에 새로운 예약을 저장
    // +) 요청(예약정보), 응답(X)
    public void save(Reservation reservation) {
        reservations.add(reservation);
    }

    // 조회(READ)
    // : 단건 예약에 대한 조회 (reservationId를 사용해서 조회)
    // +) 요청(예약 고유번호), 응답(예약 정보)
    // Optional => 예약이 있을수도 있고 없을수도 있으므로 Optional이라는 포장지로 감싸서 NullPointException을 초기에 막는다
    public Optional<Reservation> findById(Long reservationId) {
        return reservations.stream()
                .filter(res -> res.getReservationId().equals(reservationId))
                .findFirst(); // 검색된 조건에 일치하는 요소 중 제일 첫 번째 요소를 Optional로 반환
    }

    // : (현재 프로젝트에서는 DB 없이 객체 내부의 상태만 변경)
    // +) 요청(사용자 ID), 응답(예약 정보 리스트)
    public List<Reservation> findByUserId(String UserId) {
        return reservations.stream()
                // 해당 예약자의 리스트 중 예약이 유효한 목록만 확인
                // isActive => true || false를 반환
                .filter(res-> res.getUserId().equals(UserId) && res.isActive())
                .collect(Collectors.toList());
    }

    // 취소(UPDATE)
    // : 예약자 정보와 일치하는 예약을 조회 (userId를 사용)


    


    
}
