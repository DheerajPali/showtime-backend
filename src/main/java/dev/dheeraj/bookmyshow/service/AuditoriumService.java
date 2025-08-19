package dev.dheeraj.bookmyshow.service;

import dev.dheeraj.bookmyshow.exception.AuditoriumNotFoundException;
import dev.dheeraj.bookmyshow.model.Auditorium;
import dev.dheeraj.bookmyshow.repository.AuditoriumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuditoriumService {

    private final AuditoriumRepository auditoriumRepository;

    public Auditorium getAuditoriumById(int id) {
        return auditoriumRepository.findById(id).orElseThrow(
                () -> new AuditoriumNotFoundException("Auditorium not found, please enter a valid auditorium id")
        );
    }

    public List<Auditorium> getAllAuditoriums() {
        return auditoriumRepository.findAll();
    }

    public Auditorium saveAuditorium(Auditorium auditorium) {
        return auditoriumRepository.save(auditorium);
    }

    public void deleteAuditoriumById(int id) {
        if (!auditoriumRepository.existsById(id)) {
            throw new AuditoriumNotFoundException("Auditorium not found with id " + id + ". It may have already been deleted.");
        }
        auditoriumRepository.deleteById(id);
    }
}
