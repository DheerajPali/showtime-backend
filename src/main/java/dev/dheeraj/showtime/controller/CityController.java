package dev.dheeraj.showtime.controller;

import dev.dheeraj.showtime.model.City;
import dev.dheeraj.showtime.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CityController {
    @Autowired
    public CityService cityService;

    @GetMapping("/cities/{id}")
    public ResponseEntity<City> getCityById(@PathVariable int id) throws Exception{
            return ResponseEntity.ok(cityService.getCityById(id));
    }

    @GetMapping("/cities")
    public ResponseEntity<List<City>> getCities(){
        return ResponseEntity.ok(cityService.getAllCities());
    }

    @PostMapping("/cities")
    public ResponseEntity<City> createCity(@RequestBody City city){
//       return ResponseEntity.ok(cityService.save(city));
        City savedCity = cityService.save(city);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCity);
    }

    @DeleteMapping("cities/{id}")
    public ResponseEntity<Void> deleteCityById(@PathVariable int id){
        cityService.deleteCityById(id);
//        System.out.println("hello ji .....");
//        return ResponseEntity.ok("City with id " + id + " deleted successfully.");
        return ResponseEntity.noContent().build();
    }

    @PutMapping("cities/{id}")
    public ResponseEntity<City> updateCity(@PathVariable int id,  @RequestBody City city){
      return ResponseEntity.ok(cityService.updateCity(id, city));
    }
}
