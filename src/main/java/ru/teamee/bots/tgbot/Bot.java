package ru.teamee.bots.tgbot;

import org.telegram.telegrambots.meta.api.methods.polls.SendPoll;
import ru.teamee.bots.*;
import ru.teamee.handling.CommandHandler;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


/* Primary Telegram Bot class (we're using LongPolling technology)
 * and this class implements Writer interface */
public class Bot extends TelegramLongPollingBot implements Writer {
    private final String botToken;
    private final String botName;
    private final CommandHandler handler;
    private final Converter converter;

    public Bot(String botName, String botToken) {
        this.handler = new CommandHandler();
        this.converter = new Converter();
        this.botName = botName;
        this.botToken = botToken;
    }


    @Override
    public String getBotUsername() {
        return this.botName;
    }

    @Override
    public String getBotToken() {
        return this.botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Request request = converter.makeRequestFromUpdate(update);
            Response response = handler.handleRequest(request);
            write(response);
        }
    }

    // Methods writes response to user's telegram chat
    @Override
    public void write(Response response) {
        if (response.getAnswer().equals("/start")) {
            SendMessage sm = converter.makeMessageFromResponse(response);
            try {
                execute(sm);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        else if (response.getAnswer().equals("/quiz")) {
            try {
                for (SimpleQuizEnum number: SimpleQuizEnum.values()) {
                    SendPoll sp = converter.makeQuizFromResponse(response, number);
                    execute(sp);
                }
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }
}
