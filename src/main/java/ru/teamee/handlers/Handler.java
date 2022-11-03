package ru.teamee.handlers;

import ru.teamee.readers.Request;
import ru.teamee.writers.Response;

public interface Handler {
    Response handleRequest(Request request);
}