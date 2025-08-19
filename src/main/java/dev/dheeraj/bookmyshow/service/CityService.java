package dev.dheeraj.bookmyshow.service;

import dev.dheeraj.bookmyshow.exception.CityNotFoundException;
import dev.dheeraj.bookmyshow.model.City;
import dev.dheeraj.bookmyshow.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//import java.util.Optional;

@Service
public class CityService {
    @Autowired
    public CityRepository cityRepository;

    public City getCityById(int id){
//        Optional<City> cityOptional =  cityRepository.findById(id);
//        if(cityOptional.isPresent()){
//            return cityOptional.get();
//        }
//        else {
//            throw new CityNotFoundException("City not found, please enter a valid city id");
//        }
        return cityRepository.findById(id).orElseThrow(
                () -> new CityNotFoundException("City not found, please enter a valid city id")
        );
    }

    public List<City> getAllCities(){
        return cityRepository.findAll();
    }

    public City save(City city){
        return cityRepository.save(city);
    }

    public void deleteCityById(int id){
        if(!cityRepository.existsById(id)){
            throw new CityNotFoundException("City not found with id " + id + " someone may already delete that");
        }
        cityRepository.deleteById(id);
    }

//    public City update(int id){
//        return cityRepository
//    }

}

