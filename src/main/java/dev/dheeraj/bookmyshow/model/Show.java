package dev.dheeraj.bookmyshow.model;

import dev.dheeraj.bookmyshow.model.constants.ShowStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Show extends BaseModel{
    private LocalDate startTime;
    private LocalDate endTime;
    private String language;
    @ManyToOne
    @JoinColumn(name="movie_id")
    private Movie movie;
    @ManyToOne
    @JoinColumn(name="auditorium_id")
    private Auditorium auditorium;
    private ShowStatus showStatus;
    @OneToMany
    @JoinColumn(name="show_id")
    private List<ShowSeat> showSeats;
}
