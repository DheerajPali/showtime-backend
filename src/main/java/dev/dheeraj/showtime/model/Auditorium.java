package dev.dheeraj.showtime.model;

import dev.dheeraj.showtime.model.constants.AuditoriumFeature;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Auditorium extends BaseModel{
    private String name;
    private int capacity;
    @OneToMany
    @JoinColumn(name="auditorium_id")
    private List<Seat> seats;
    @OneToMany
    @JoinColumn(name="auditorium_id")
    private List<Show> shows;
    private List<AuditoriumFeature> auditoriumFeatures;
}
