package dev.dheeraj.showtime.model;

import dev.dheeraj.showtime.model.constants.ShowStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@Entity
public class Show extends BaseModel{
    private LocalDateTime startTime;
    private LocalDateTime endTime;
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
