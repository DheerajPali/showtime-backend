package dev.dheeraj.showtime.model;

import dev.dheeraj.showtime.model.constants.UserRole;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "BMS_User")
public class User extends BaseModel{
    private String name;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    @OneToMany
    @JoinColumn(name="bms_user_id")
    private List<Ticket> tickets;

}
