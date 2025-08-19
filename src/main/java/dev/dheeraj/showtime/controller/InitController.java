package dev.dheeraj.showtime.controller;

import dev.dheeraj.showtime.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InitController {
    @Autowired
    private InitService initService;

    @GetMapping("/init")
    public ResponseEntity<Boolean> init(){
        initService.initialise();
        return ResponseEntity.ok(true);
    }
}
