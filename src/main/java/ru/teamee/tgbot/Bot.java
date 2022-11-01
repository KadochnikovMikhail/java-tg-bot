package ru.teamee.tgbot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "EnglishTasker";
    }

    @Override
    public String getBotToken() {
        return "5436251457:AAHNVvR--1JWY7oPJkeFuCxUWMW8Gi-YSIA";
    }

    @Override
    public void onUpdateReceived(Update update) {
        var msg = update.getMessage();
        var user = msg.getFrom();
        System.out.println(user.getFirstName() + " wrote " + msg.getText());
        sendText(user.getId(), msg.getText());
    }

    public void sendText(Long who, String text) {  //Who are we sending a message to + message content
        SendMessage sm = SendMessage.builder().chatId(who.toString()).text(text).build();
        try {
            execute(sm);                //Actually sending the message
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
