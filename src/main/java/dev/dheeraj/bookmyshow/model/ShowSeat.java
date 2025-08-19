package dev.dheeraj.bookmyshow.model;

import dev.dheeraj.bookmyshow.model.constants.ShowSeatStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

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
