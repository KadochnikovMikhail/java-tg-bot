package ru.teamee.bots.responses;

import javax.annotation.Nullable;

public class ResponseWithEcho extends Response {

    public ResponseWithEcho(@Nullable String message, Long userID) {
        super(message, userID, null);
    }
}
