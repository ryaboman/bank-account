package ru.ryaboman.projects.bankAccount.exception.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private LocalDateTime date;
    private String message;
}
