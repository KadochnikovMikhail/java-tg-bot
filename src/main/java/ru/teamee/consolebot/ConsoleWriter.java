package ru.teamee.consolebot;

import ru.teamee.writers.Response;
import ru.teamee.writers.ResponseWithError;
import ru.teamee.writers.Writer;

public class ConsoleWriter implements Writer {

    @Override
    public void write(Response response){
        // Write message in console
        if (response instanceof ResponseWithError) {
            System.out.println("Error: " + response.getAnswer());
        }
        System.out.println(response.getAnswer());
    }
}
