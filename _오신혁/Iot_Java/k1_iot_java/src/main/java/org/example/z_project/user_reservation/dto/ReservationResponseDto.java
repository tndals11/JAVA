package org.example.z_project.user_reservation.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@Getter
public class ReservationResponseDto {
    private Long reservationId;
    private String userId;
    private Date reservationTime;
    private String activeMessage;

    @Override
    public String toString() {
        return "회원 ID : " + userId + ", 예약 날짜 : " + reservationTime + ", 예약 : " + activeMessage ;
    }
}
