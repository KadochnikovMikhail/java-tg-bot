package ru.teamee.tgbot;

public class Request {
    private final String message;

    public Request(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}