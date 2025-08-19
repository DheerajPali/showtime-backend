package dev.dheeraj.showtime.model;

import dev.dheeraj.showtime.model.constants.SeatStatus;
import dev.dheeraj.showtime.model.constants.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Seat extends BaseModel{
    private int row;
    private int col;
    private String seatNumber;
    @Enumerated(EnumType.STRING)
    private SeatType seatType;
    @Enumerated(EnumType.STRING)
    private SeatStatus seatStatus;
}
