package me.dio.avanade_2024.controller.exception;

public class EventNotFoundException extends RuntimeException {
    public EventNotFoundException(String message) {
        super(message);
    }
    public EventNotFoundException() { super("Event not found"); }
}
