package ru.teamee.bots.responses;

import javax.annotation.Nullable;

public class ResponseWithUnfinishedQuiz extends Response {

    public ResponseWithUnfinishedQuiz(@Nullable String message, Long userID) {
        super(message, userID, null);
    }
}
