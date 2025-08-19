package dev.dheeraj.showtime.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Ticket extends BaseModel{
    @OneToMany
    @JoinColumn(name="ticket_id")
    private List<ShowSeat> showSeats;
    @ManyToOne
    @JoinColumn(name="show_id")
    private Show show;
    private double totalCost;
    @ManyToOne
    @JoinColumn(name="bms_user_id")
    private User user;
}
