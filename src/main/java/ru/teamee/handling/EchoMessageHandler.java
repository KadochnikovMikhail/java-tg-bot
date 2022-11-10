package ru.teamee.handling;

import ru.teamee.bots.Request;
import ru.teamee.bots.Response;
import ru.teamee.bots.ResponseWithError;

/* Handler class which main function is to take Request and give Response to Writer */
public class EchoMessageHandler implements Handler {
    private static final String EMPTY_STROKE = "";
    ResponseWithError EMPTY_INPUT_CONSOLE_RESPONSE = new ResponseWithError("input can not be empty");

    public Response handleRequest(Request request) {
        // "if" helps to understand if program is running console echo bot or telegram
        if (request.getUserID() == null) {
            String requestText = request.getMessage();
            return EMPTY_STROKE.equals(requestText) ? EMPTY_INPUT_CONSOLE_RESPONSE : new Response(requestText);
        }
        return new Response(request.getMessage(), request.getUserID());
    }
}