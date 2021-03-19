package com.ihnat.mikhalkovich.reservationservices;

import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    List<Reservation> getReservationByReservationDate(LocalDate reservationDate);
}
