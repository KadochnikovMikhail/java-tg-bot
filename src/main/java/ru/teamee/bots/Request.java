package ru.teamee.bots;


/* Class helps to store and prepare data from user's request for Handler */
public class Request {
    private final String message;
    private final Long userID;

    // Console bot constructor
    public Request(String message) {
        this.userID = null;
        this.message = message;
    }

    // Telegram bot constructor
    public Request(String message, Long userID) {
        this.message = message;
        this.userID = userID;
    }

    public String getMessage() {
        return message;
    }

    public Long getUserID() {
        return this.userID;
    }
}