package com.ihnat.mikhalkovich.roomreservationservice;

import com.ihnat.mikhalkovich.roomreservationservice.entity.Guest;
import com.ihnat.mikhalkovich.roomreservationservice.entity.Reservation;
import com.ihnat.mikhalkovich.roomreservationservice.entity.Room;
import com.ihnat.mikhalkovich.roomreservationservice.entity.RoomReservation;
import com.ihnat.mikhalkovich.roomreservationservice.feignclient.GuestClient;
import com.ihnat.mikhalkovich.roomreservationservice.feignclient.ReservationClient;
import com.ihnat.mikhalkovich.roomreservationservice.feignclient.RoomClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/room-reservations")
@RequiredArgsConstructor
public class RoomReservationWebService {
    private final RoomClient roomClient;
    private final ReservationClient reservationClient;
    private final GuestClient guestClient;

    @GetMapping
    public List<RoomReservation> getRoomReservations(@RequestParam(required = false) LocalDate date) {
        final List<Reservation> reservations = this.reservationClient.getAllReservations(date);
        return reservations.stream().map(reservation -> {
            final Room room = roomClient.getRoom(reservation.getRoomId());
            final Guest guest = guestClient.getGuest(reservation.getGuestId());
            return RoomReservation.builder()
                    .roomId(room.getId())
                    .roomName(room.getName())
                    .roomNumber(room.getRoomNumber())
                    .guestId(guest.getId())
                    .firstName(guest.getFirstName())
                    .lastName(guest.getLastName())
                    .date(reservation.getReservationDate())
                    .build();
        }).collect(Collectors.toList());
    }
}
