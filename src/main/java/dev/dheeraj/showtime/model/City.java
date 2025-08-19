package dev.dheeraj.showtime.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class City extends BaseModel{
    private String name;
    @OneToMany
    @JoinColumn(name="city_id")
    private List<Theatre> theatres;

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

//    public List<Theatre> getTheatres() {
//        return theatres;
//    }
//
//    public void setTheatres(List<Theatre> theatres) {
//        this.theatres = theatres;
//    }
}

//Persistent entity 'City' should have primary key