package ru.teamee.bots;


import org.telegram.telegrambots.meta.api.objects.polls.PollAnswer;

import java.util.HashMap;

/* Class helps to store and prepare data from user's request for Handler */
public class Request {
    private final String message;
    private final long userID;

    private final PollAnswer pollAnswer;


    // Telegram bot constructor

    public Request(String message, Long userID, PollAnswer pollAnswer) {
        this.message = message;
        this.userID = userID;
        this.pollAnswer = pollAnswer;
    }

    // Console bot constructor
    public Request(String message) {
        this(message, null, null);
    }

    public String getMessage() {
        return message;
    }

    public Long getUserID() {
        return userID;
    }

    public PollAnswer getPollAnswer() {
        return pollAnswer;
    }
}