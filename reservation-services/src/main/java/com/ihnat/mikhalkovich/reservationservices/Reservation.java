package com.ihnat.mikhalkovich.reservationservices;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RESERVATION")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RESERVATION_ID")
    private long reservationId;
    @Column(name = "GUEST_ID")
    private long guestId;
    @Column(name = "ROOM_ID")
    private long roomId;
    @Column(name = "RES_DATE")
    private LocalDate reservationDate;
}
