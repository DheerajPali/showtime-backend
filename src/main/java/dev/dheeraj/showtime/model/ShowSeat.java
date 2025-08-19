package dev.dheeraj.showtime.model;

import dev.dheeraj.showtime.model.constants.ShowSeatStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel{
    private int price;
    @ManyToOne
    @JoinColumn(name="show_id")
    private Show show;
    @ManyToOne
    @JoinColumn(name="seat_id")
    private Seat seat;
    private ShowSeatStatus showSeatStatus;
}
