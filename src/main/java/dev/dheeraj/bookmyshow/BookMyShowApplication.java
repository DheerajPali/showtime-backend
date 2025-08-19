package dev.dheeraj.showtime;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class BookMyShowApplication {

        public static void main(String[] args) {
            // Force JVM timezone before Spring Boot starts
            System.setProperty("user.timezone", "UTC");
            TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

            SpringApplication.run(BookMyShowApplication.class, args);
        }

}

