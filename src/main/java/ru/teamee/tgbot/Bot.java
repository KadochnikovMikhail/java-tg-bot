package ru.teamee.tgbot;

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

    public Bot(String botName, String botToken) {
        this.handler = new InputHandler();
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
            String message = update.getMessage().getText();
            Long userID = update.getMessage().getFrom().getId();

            Request request = new Request(message, userID);
            Response response = handler.handleRequest(request);
            write(response);
        }
    }

    // Methods writes response to user's telegram chat
    @Override
    public void write(Response response) {
        SendMessage sm = SendMessage.builder()
                .chatId(response.getUserID().toString())
                .text(response.getAnswer())
                .build();
        try {
            execute(sm);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
