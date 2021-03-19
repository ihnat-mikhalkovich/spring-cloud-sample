package com.ihnat.mikhalkovich.roomreservationservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    private long reservationId;
    private long guestId;
    private long roomId;
    private LocalDate reservationDate;
}
