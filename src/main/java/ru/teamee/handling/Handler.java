package ru.teamee.handling;

import ru.teamee.bots.Request;
import ru.teamee.bots.Response;

public interface Handler {
    Response handleRequest(Request request);
}