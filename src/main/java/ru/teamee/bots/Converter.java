package ru.teamee.bots;

import org.telegram.telegrambots.meta.api.methods.polls.SendPoll;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.ArrayList;
import java.util.Arrays;

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

    public SendPoll makeQuizFromResponse(Response response, SimpleQuizEnum number) {
        SendPoll sendPoll = null;
        switch (number) {
            case FIRST -> {
                ArrayList<String> list = new ArrayList<>(
                        Arrays.asList("Неправильный ответ", "Неправильный ответ", "Почти правильный ответ", "Правильный ответ"));
                sendPoll = SendPoll.builder()
                        .chatId(response.getUserID().toString())
                        .question("Опрос №1")
                        .options(list)
                        .type("quiz")
                        .correctOptionId(3)
                        .explanation("Надо было выбирать правильный ответ")
                        .protectContent(true)
                        .build();
            }
            case SECOND -> {
                ArrayList<String> list = new ArrayList<>(
                        Arrays.asList("Неправильный ответ", "Неправильный ответ", "Почти правильный ответ", "Правильный ответ"));
                sendPoll = SendPoll.builder()
                        .chatId(response.getUserID().toString())
                        .question("Опрос №2")
                        .options(list)
                        .type("quiz")
                        .correctOptionId(3)
                        .explanation("тут пояснения если что-то не так сделано")
                        .protectContent(true)
                        .build();
            }
//            case THIRD -> {
//                ArrayList<String> list = new ArrayList<>(
//                        Arrays.asList("Неправильный ответ", "Неправильный ответ", "Почти правильный ответ", "Правильный ответ"));
//                sendPoll = SendPoll.builder()
//                        .chatId(response.getUserID().toString())
//                        .question("Опрос №3")
//                        .options(list)
//                        .type("quiz")
//                        .correctOptionId(3)
//                        .explanation("тут пояснения если что-то не так сделано")
//                        .protectContent(true)
//                        .build();
//            }
//            case FOURTH -> {
//                ArrayList<String> list = new ArrayList<>(
//                        Arrays.asList("Неправильный ответ", "Правильный ответ", "Почти правильный ответ", "Неправильный ответ"));
//                sendPoll = SendPoll.builder()
//                        .chatId(response.getUserID().toString())
//                        .question("Опрос №4")
//                        .options(list)
//                        .type("quiz")
//                        .correctOptionId(1)
//                        .explanation("тут пояснения если что-то не так сделано")
//                        .protectContent(true)
//                        .build();
//            }
//            case FIFTH -> {
//                ArrayList<String> list = new ArrayList<>(
//                        Arrays.asList("Неправильный ответ", "Правильный ответ", "Почти правильный ответ", "Неправильный ответ"));
//                sendPoll = SendPoll.builder()
//                        .chatId(response.getUserID().toString())
//                        .question("Опрос №5")
//                        .options(list)
//                        .type("quiz")
//                        .correctOptionId(1)
//                        .explanation("тут пояснения если что-то не так сделано")
//                        .protectContent(true)
//                        .build();
//            }
//            case SIXTH -> {
//                ArrayList<String> list = new ArrayList<>(
//                        Arrays.asList("Неправильный ответ", "Правильный ответ", "Почти правильный ответ", "Неправильный ответ"));
//                sendPoll = SendPoll.builder()
//                        .chatId(response.getUserID().toString())
//                        .question("Опрос №6")
//                        .options(list)
//                        .type("quiz")
//                        .correctOptionId(1)
//                        .explanation("тут пояснения если что-то не так сделано")
//                        .protectContent(true)
//                        .build();
//            }
//            case SEVENTH -> {
//                ArrayList<String> list = new ArrayList<>(
//                        Arrays.asList("Неправильный ответ", "Правильный ответ", "Почти правильный ответ", "Неправильный ответ"));
//                sendPoll = SendPoll.builder()
//                        .chatId(response.getUserID().toString())
//                        .question("Опрос №7")
//                        .options(list)
//                        .type("quiz")
//                        .correctOptionId(1)
//                        .explanation("тут пояснения если что-то не так сделано")
//                        .protectContent(true)
//                        .build();
//            }
//            case EIGHT -> {
//                ArrayList<String> list = new ArrayList<>(
//                        Arrays.asList("Неправильный ответ", "Правильный ответ", "Почти правильный ответ", "Неправильный ответ"));
//                sendPoll = SendPoll.builder()
//                        .chatId(response.getUserID().toString())
//                        .question("Опрос №8")
//                        .options(list)
//                        .type("quiz")
//                        .correctOptionId(1)
//                        .explanation("тут пояснения если что-то не так сделано")
//                        .protectContent(true)
//                        .build();
//            }
//            case NINTH -> {
//                ArrayList<String> list = new ArrayList<>(
//                        Arrays.asList("Неправильный ответ", "Правильный ответ", "Почти правильный ответ", "Неправильный ответ"));
//                sendPoll = SendPoll.builder()
//                        .chatId(response.getUserID().toString())
//                        .question("Опрос №9")
//                        .options(list)
//                        .type("quiz")
//                        .correctOptionId(1)
//                        .explanation("тут пояснения если что-то не так сделано")
//                        .protectContent(true)
//                        .build();
//            }
        }
        return sendPoll;
    }
}
