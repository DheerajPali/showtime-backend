package dev.dheeraj.showtime.service;

import dev.dheeraj.showtime.exception.AuditoriumNotFoundException;
import dev.dheeraj.showtime.model.Auditorium;
import dev.dheeraj.showtime.repository.AuditoriumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuditoriumService {

    @Autowired
    private AuditoriumRepository auditoriumRepository;

    public Auditorium getAuditoriumById(int id) {
        return auditoriumRepository.findById(id).orElseThrow(
                () -> new AuditoriumNotFoundException("Auditorium not found, please enter a valid auditorium id")
        );
    }

    public List<Auditorium> getAllAuditoriums() {
        return auditoriumRepository.findAll();
    }

    public Auditorium createAuditorium(Auditorium auditorium) {
        return auditoriumRepository.save(auditorium);
    }

    public void deleteAuditoriumById(int id) {
        if (!auditoriumRepository.existsById(id)) {
            throw new AuditoriumNotFoundException("Auditorium not found with id " + id + ". It may have already been deleted.");
        }
        auditoriumRepository.deleteById(id);
    }
}
