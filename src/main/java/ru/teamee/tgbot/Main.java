package ru.teamee.tgbot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        Bot bot = new Bot();
        botsApi.registerBot(bot);

//        Writer consoleWriter = new ConsoleWriter();
//        Reader consoleReader = new ConsoleReader(consoleWriter);
//        Handler inputHandler = new InputHandler();
//        boolean isBotRunning = true;
//        while (isBotRunning) {
//            Request data = consoleReader.read();
//            isBotRunning = consoleWriter.consoleWrite(inputHandler.handleRequest(data));
//
//        }
    }
}