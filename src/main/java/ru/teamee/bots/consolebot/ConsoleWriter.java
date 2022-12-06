package ru.teamee.bots.consolebot;

import ru.teamee.bots.responses.Response;
import ru.teamee.bots.Writer;

public class ConsoleWriter implements Writer {

    @Override
    public void write(Response response) {
        // Write message in console
        if (response instanceof ResponseWithError) {
            System.out.println("Error: " + response.getMessage());
        }
        System.out.println(response.getMessage());
    }
}
