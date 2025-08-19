package dev.dheeraj.showtime.model;

import dev.dheeraj.showtime.model.constants.MovieFeature;
import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class Movie extends BaseModel{
    private String title;
    private String language;
    private double lengthInMinutes;
    private List<MovieFeature> movieFeatures;
}
