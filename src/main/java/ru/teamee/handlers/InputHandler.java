package ru.teamee.handlers;

import ru.teamee.readers.Request;
import ru.teamee.writers.Response;
import ru.teamee.writers.ResponseWithError;

public class InputHandler implements Handler {
    private static final String EMPTY_STROKE = "";
    ResponseWithError EMPTY_INPUT_CONSOLE_RESPONSE = new ResponseWithError("input can not be empty");

    public Response handleRequest(Request request) {
        if (request.getUserID() == null) {
            String requestText = request.getMessage();
            return EMPTY_STROKE.equals(requestText) ? EMPTY_INPUT_CONSOLE_RESPONSE : new Response(requestText);
        }
        return new Response(request.getMessage(), request.getUserID());
    }
}