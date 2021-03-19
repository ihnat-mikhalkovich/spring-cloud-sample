package com.ihnat.mikhalkovich.reservationservices;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationServices {
    private final ReservationRepository reservationRepository;

    @GetMapping
    public Iterable<Reservation> getReservations(@RequestParam(required = false) LocalDate date) {
        if (Objects.isNull(date)) {
            return this.reservationRepository.findAll();
        } else {
            return reservationRepository.getReservationByReservationDate(date);
        }
    }

    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable("id") long id) {
        return this.reservationRepository.findById(id).get();
    }
}
