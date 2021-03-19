package com.ihnat.mikhalkovich.roomreservationservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    private long id;
    private String name;
    private String roomNumber;
    private String bedInfo;
}
