package ru.teamee.readers;

import org.telegram.telegrambots.meta.api.objects.Update;

/* Class helps to store and prepare data from user's request for Handler */
public class Request {
    private final String message;
    private final Update update;
    private final Long userID;

    // Console bot constructor
    public Request(String message) {
        this.update = null;
        this.userID = null;
        this.message = message;
    }

    // Telegram bot constructor
    public Request(Update update) {
        this.update = update;
        this.message = this.update.getMessage().getText();
        this.userID = this.update.getMessage().getFrom().getId();
    }
    public String getMessage() {
        return message;
    }
    public Long getUserID() {return this.userID;}
}