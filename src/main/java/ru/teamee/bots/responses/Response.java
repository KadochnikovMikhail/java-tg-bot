package ru.teamee.bots.responses;

import org.telegram.telegrambots.meta.api.objects.polls.PollAnswer;

import javax.annotation.Nullable;

/* Class helps to store and prepare data from Handler for Writer */
public class Response {
    private final String message;
    private final Long userID;
    private final PollAnswer pollAnswer;

    // Telegram bot constructor
    public Response(@Nullable String message, Long userID, @Nullable PollAnswer pollAnswer) {
        this.message = message;
        this.userID = userID;
        this.pollAnswer = pollAnswer;
    }

    // Console bot constructor
    public Response(String message) {
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
