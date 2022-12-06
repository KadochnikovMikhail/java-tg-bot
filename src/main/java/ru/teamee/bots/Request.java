package ru.teamee.bots;


import org.telegram.telegrambots.meta.api.objects.polls.PollAnswer;

import java.util.HashMap;

/* Class helps to store and prepare data from user's request for Handler */
public class Request {
    private final String message;
    private final long userID;

    private final PollAnswer pollAnswer;
    private final boolean isQuizRunning;
    private final HashMap<String, Integer> mapWithRightAnswers;

    // Telegram bot constructor

    public Request(String message, Long userID, PollAnswer pollAnswer, boolean isQuizRunning,
                   HashMap<String, Integer> mapWithRightAnswers) {
        this.message = message;
        this.userID = userID;
        this.pollAnswer = pollAnswer;
        this.isQuizRunning = isQuizRunning;
        this.mapWithRightAnswers = mapWithRightAnswers;
    }

    // Console bot constructor
    public Request(String message) {
        this(message, null, null, false, null);
    }

    public String getMessage() {
        return message;
    }

    public Long getUserID() {
        return userID;
    }

    public boolean isQuizRunning() {
        return isQuizRunning;
    }

    public HashMap<String, Integer> getMapWithRightAnswers() {
        return mapWithRightAnswers;
    }

    public PollAnswer getPollAnswer() {
        return pollAnswer;
    }
}