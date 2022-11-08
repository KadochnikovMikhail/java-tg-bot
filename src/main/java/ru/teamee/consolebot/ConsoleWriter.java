package ru.teamee.consolebot;

import ru.teamee.bots.Response;
import ru.teamee.bots.ResponseWithError;
import ru.teamee.bots.Writer;

public class ConsoleWriter implements Writer {

    @Override
    public void write(Response response) {
        // Write message in console
        if (response instanceof ResponseWithError) {
            System.out.println("Error: " + response.getAnswer());
        }
        System.out.println(response.getAnswer());
    }
}
