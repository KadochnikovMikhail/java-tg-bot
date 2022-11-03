package ru.teamee.tgbot;

import ru.teamee.handlers.InputHandler;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.teamee.readers.Request;
import ru.teamee.writers.Response;
import ru.teamee.writers.Writer;

public class Bot extends TelegramLongPollingBot implements Writer {
    private final String botToken;
    private final String botName;
    private final InputHandler handler;

    public Bot(String bot_name, String bot_token) {
        this.handler = new InputHandler();
        this.botName = bot_name;
        this.botToken = bot_token;
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
        Request request = new Request(update);
        Response response = handler.handleRequest(request);
        write(response);

//        var msg = update.getMessage();
//        var user = msg.getFrom();
//        System.out.println(user.getFirstName() + " wrote " + msg.getText());
//        sendText(user.getId(), msg.getText());
    }
    @Override
    public void write(Response response) {  //Who are we sending a message to + message content
        SendMessage sm = SendMessage.builder().chatId(response.getUserID().toString()).text(response.getAnswer()).build();
        try {
            execute(sm);                            //Actually sending the message
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
