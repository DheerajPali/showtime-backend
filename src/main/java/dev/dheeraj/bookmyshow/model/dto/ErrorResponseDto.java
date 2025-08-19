package dev.dheeraj.bookmyshow.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
public class ErrorResponseDto {
    private int status;
    private String error;
    private String message;

}
