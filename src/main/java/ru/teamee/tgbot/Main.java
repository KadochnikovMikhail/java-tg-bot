package ru.teamee.tgbot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        Bot bot = new Bot();
        botsApi.registerBot(bot);

//        ConsoleReader r1 = new ConsoleReader();
//        ConsoleWriter w1 = new ConsoleWriter();
//        InputHandler h1 = new InputHandler();
//        boolean flag = true;
//        while (flag) {
//            RequestStructure data = r1.consoleRead();
//            flag = w1.consoleWrite(h1.takeData(data));
//        }
    }
}