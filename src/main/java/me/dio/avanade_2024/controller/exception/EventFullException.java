package me.dio.avanade_2024.controller.exception;

public class EventFullException extends RuntimeException {
    public EventFullException(String message) {super(message);}
    public EventFullException() {super("Event full");}
}
