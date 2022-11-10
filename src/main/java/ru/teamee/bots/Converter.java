package ru.teamee.bots;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Converter {
    public Request makeRequestFromUpdate(Update update) {
        String message = update.getMessage().getText();
        Long userID = update.getMessage().getFrom().getId();
        return new Request(message, userID);
    }

    public SendMessage makeMessageFromResponse(Response response) {
        return  SendMessage.builder()
                .chatId(response.getUserID().toString())
                .text(response.getAnswer())
                .build();
    }
}
