package dev.dheeraj.showtime.model;

import dev.dheeraj.showtime.model.constants.MovieFeature;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Movie extends BaseModel{
    private String title;
    private String language;
    private double lengthInMinutes;
    private List<MovieFeature> movieFeatures;
}
