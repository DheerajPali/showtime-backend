package dev.dheeraj.bookmyshow.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

import javax.management.ConstructorParameters;

@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
public class ErrorResponseDto {
    private int status;
    private String error;
    private String message;

}
