package ru.teamee.handling;

import ru.teamee.bots.Request;
import ru.teamee.bots.Response;

public class CommandHandler implements Handler {

    @Override
    public Response handleRequest(Request request) {
        String message = request.getMessage();
        if (message.startsWith("/start")) {
            message = "/start";
        }
        else if (message.startsWith("/quiz")) {
            message = "/quiz";
        }
        return new Response(message, request.getUserID());
    }
}
