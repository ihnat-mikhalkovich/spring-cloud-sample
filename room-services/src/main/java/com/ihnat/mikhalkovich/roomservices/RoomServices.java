package com.ihnat.mikhalkovich.roomservices;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomServices {
    private final RoomRepository roomRepository;

    @GetMapping
    public Iterable<Room> getRooms() {
        return this.roomRepository.findAll();
    }

    @GetMapping("/{id}")
    public Room getRoom(@PathVariable("id") long id) {
        return this.roomRepository.findById(id).get();
    }
}
