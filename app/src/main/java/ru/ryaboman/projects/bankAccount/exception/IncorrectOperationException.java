package ru.ryaboman.projects.bankAccount.exception;

public class IncorrectOperationException extends RuntimeException {
    public IncorrectOperationException(final String message) {
        super(message);
    }
}
