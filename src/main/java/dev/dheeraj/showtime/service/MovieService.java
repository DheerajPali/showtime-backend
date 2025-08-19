package dev.dheeraj.showtime.service;

import dev.dheeraj.showtime.exception.MovieNotFoundException;
import dev.dheeraj.showtime.model.Movie;
import dev.dheeraj.showtime.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MovieService {
    @Autowired
    public MovieRepository movieRepository;

    public Movie getMovieById(int id){
        return movieRepository.findById(id).orElseThrow(
                () -> new MovieNotFoundException("Movie not found, please enter a valid city id")
        );
    }

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Movie saveMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public void deleteMovieById(int id){
        if(!movieRepository.existsById(id)){
            throw new MovieNotFoundException("Movie not found with id " + id + " someone may already delete that");
        }
        movieRepository.deleteById(id);
    }

}

