package ru.teamee.tgbot;

import ru.teamee.bots.Converter;
import ru.teamee.handling.InputHandler;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.teamee.bots.Request;
import ru.teamee.bots.Response;
import ru.teamee.bots.Writer;


/* Primary Telegram Bot class (we're using LongPolling technology)
 * and this class implements Writer interface */
public class Bot extends TelegramLongPollingBot implements Writer {
    private final String botToken;
    private final String botName;
    private final InputHandler handler;
    private final Converter converter;

    public Bot(String botName, String botToken) {
        this.handler = new InputHandler();
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
        SendMessage sm = converter.makeMessageFromResponse(response);
        try {
            execute(sm);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
