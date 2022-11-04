package ru.teamee;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.teamee.readers.Request;
import ru.teamee.handlers.Handler;
import ru.teamee.handlers.InputHandler;
import ru.teamee.consolebot.Reader;
import ru.teamee.consolebot.ConsoleReader;
import ru.teamee.consolebot.ConsoleWriter;
import ru.teamee.tgbot.Bot;
import ru.teamee.writers.Writer;

import java.util.Map;

public class Main {
    public static void main(String[] args) throws TelegramApiException {
//        consoleBot();
        telegramBot();
    }
    // Method which find bot token in Windows Environment variables
    private static String GetTokenFromEnvironmentVariables() {
        return System.getenv("EnglishBotToken");
    }

    private static void telegramBot() {
        String botName = "EnglishTasker";
        String botToken = GetTokenFromEnvironmentVariables();
        startTelegramBot(botName, botToken);
    }

    // Method launches Telegram Bot in main
    private static void startTelegramBot(String botName, String botToken) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new Bot(botName, botToken));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    // Method launches Console Echo bot in main
    private static void consoleBot() {
        Writer consoleWriter = new ConsoleWriter();
        Reader consoleReader = new ConsoleReader(consoleWriter);
        Handler inputHandler = new InputHandler();

        while (true) {
            Request data = consoleReader.read();
            if (data.getMessage().equals("")) {
                break;
            }
            consoleWriter.write(inputHandler.handleRequest(data));
        }
    }
}