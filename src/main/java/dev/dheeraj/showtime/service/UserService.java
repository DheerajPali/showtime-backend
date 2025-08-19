package dev.dheeraj.showtime.service;

import dev.dheeraj.showtime.exception.UserNotFoundException;
import dev.dheeraj.showtime.model.User;
import dev.dheeraj.showtime.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getUserById(int id) {
        return userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("User not found, please provide a valid user id")
        );
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUserById(int id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("User not found with id " + id + ". It may have already been deleted.");
        }
        userRepository.deleteById(id);
    }
}
