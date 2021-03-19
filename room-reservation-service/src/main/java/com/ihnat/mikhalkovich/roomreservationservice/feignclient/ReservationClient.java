package com.ihnat.mikhalkovich.roomreservationservice.feignclient;

import com.ihnat.mikhalkovich.roomreservationservice.entity.Reservation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@FeignClient("reservationservices")
public interface ReservationClient {

    @GetMapping("/reservations")
    List<Reservation> getAllReservations(
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date);

    @GetMapping("/reservations/{id}")
    Reservation getReservation(@PathVariable("id") long id);
}
