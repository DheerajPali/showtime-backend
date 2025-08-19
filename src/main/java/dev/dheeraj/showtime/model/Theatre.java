package dev.dheeraj.showtime.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Theatre extends BaseModel{
    private String name;
    private String address;
    @OneToMany
    @JoinColumn(name="theatre_id")
    private List<Auditorium> auditoriums;
}
