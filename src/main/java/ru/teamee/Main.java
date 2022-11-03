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
    private static String GetTokenFromEnvironmentVariables() {
        return System.getenv("EnglishBotToken");
    }
    public static void telegramBot() {
        String botName = "EnglishTasker";
        String botToken = GetTokenFromEnvironmentVariables();
        GetTokenFromEnvironmentVariables();
        startTelegramBot(botName, botToken);
    }

    private static void startTelegramBot(String botName, String botToken) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new Bot(botName, botToken));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public static void consoleBot() {
        System.out.println(GetTokenFromEnvironmentVariables());
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