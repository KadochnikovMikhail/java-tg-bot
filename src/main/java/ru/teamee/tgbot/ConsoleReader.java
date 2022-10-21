package ru.teamee.tgbot;

import java.util.Scanner;

public class ConsoleReader implements Reader {
    private static final Response INPUT_RESPONSE = new Response("Input: ");
    private final Scanner consoleScanner = new Scanner(System.in);
    private final Writer writer;

    public ConsoleReader(Writer writer) {
        this.writer = writer;
    }

    @Override
    public Request read() {
        // Reading from console and return Request
        writer.consoleWrite(INPUT_RESPONSE);
        return new Request(consoleScanner.nextLine());
    }
}