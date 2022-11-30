package ru.teamee.bots;

import org.telegram.telegrambots.meta.api.methods.polls.SendPoll;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class Converter {
    public Request makeRequestFromUpdate(Update update) {
        String message = update.getMessage().getText();
        Long userID = update.getMessage().getFrom().getId();
        return new Request(message, userID);
    }

    public SendMessage makeMessageFromResponse(Response response) {
        return SendMessage.builder()
                .chatId(response.getUserID().toString())
                .text(response.getAnswer())
                .build();
    }

    public Request makeQuizAnswerRequestFromUpdate(Update update, HashMap<String, Integer> quizIdMap) {
        System.out.println(update.getPollAnswer() + " - poll answer");
        int usersChosenID = update.getPollAnswer().getOptionIds().get(0);
        int correctAnswerID = quizIdMap.get(update.getPollAnswer().getPollId());
        if (Objects.equals(usersChosenID, correctAnswerID)) {
            System.out.println("Right answer");
        } else {
            System.out.println("Wrong answer");
        }
        quizIdMap.remove(update.getPollAnswer().getPollId());
        String message = "";
        Long userID = update.getPollAnswer().getUser().getId();
        return new Request(message, userID, quizIdMap.isEmpty());
    }

    public SendPoll makeQuizFromResponse(Response response, SimpleQuizEnum number) {
        SendPoll sendPoll = null;
        ArrayList<String> list;
        switch (number) {
            case FIRST -> {
                list = new ArrayList<>(
                        Arrays.asList("Неправильный ответ", "Неправильный ответ", "Почти правильный ответ", "Правильный ответ"));
                sendPoll = SendPoll.builder()
                        .chatId(response.getUserID().toString())
                        .question("Put the words in the correct order to make sentences.\n" +
                                "booked / a / we / suite / for / at / the / resort / spa / two")
                        .isAnonymous(Boolean.FALSE)
                        .options(list)
                        .type("quiz")
                        .correctOptionId(3)
                        .explanation("Надо было выбирать правильный ответ")
                        .protectContent(true)
                        .build();
            }
            case SECOND -> {
                list = new ArrayList<>(
                        Arrays.asList("Неправильный ответ", "Неправильный ответ", "Почти правильный ответ", "Правильный ответ"));
                sendPoll = SendPoll.builder()
                        .chatId(response.getUserID().toString())
                        .question("Опрос №2")
                        .isAnonymous(Boolean.FALSE)
                        .options(list)
                        .type("quiz")
                        .correctOptionId(3)
                        .explanation("тут пояснения если что-то не так сделано")
                        .protectContent(true)
                        .build();
            }
            case THIRD -> {
                list = new ArrayList<>(
                        Arrays.asList("Неправильный ответ", "Неправильный ответ", "Почти правильный ответ", "Правильный ответ"));
                sendPoll = SendPoll.builder()
                        .chatId(response.getUserID().toString())
                        .question("Опрос №3")
                        .isAnonymous(Boolean.FALSE)
                        .options(list)
                        .type("quiz")
                        .correctOptionId(3)
                        .explanation("тут пояснения если что-то не так сделано")
                        .protectContent(true)
                        .build();
            }
            case FOURTH -> {
                list = new ArrayList<>(
                        Arrays.asList("Неправильный ответ", "Правильный ответ", "Почти правильный ответ", "Неправильный ответ"));
                sendPoll = SendPoll.builder()
                        .chatId(response.getUserID().toString())
                        .question("Опрос №4")
                        .isAnonymous(Boolean.FALSE)
                        .options(list)
                        .type("quiz")
                        .correctOptionId(1)
                        .explanation("тут пояснения если что-то не так сделано")
                        .protectContent(true)
                        .build();
            }
            case FIFTH -> {
                list = new ArrayList<>(
                        Arrays.asList("Неправильный ответ", "Правильный ответ", "Почти правильный ответ", "Неправильный ответ"));
                sendPoll = SendPoll.builder()
                        .chatId(response.getUserID().toString())
                        .question("Опрос №5")
                        .isAnonymous(Boolean.FALSE)
                        .options(list)
                        .type("quiz")
                        .correctOptionId(1)
                        .explanation("тут пояснения если что-то не так сделано")
                        .protectContent(true)
                        .build();
            }
            case SIXTH -> {
                list = new ArrayList<>(
                        Arrays.asList("Неправильный ответ", "Правильный ответ", "Почти правильный ответ", "Неправильный ответ"));
                sendPoll = SendPoll.builder()
                        .chatId(response.getUserID().toString())
                        .question("Опрос №6")
                        .isAnonymous(Boolean.FALSE)
                        .options(list)
                        .type("quiz")
                        .correctOptionId(1)
                        .explanation("тут пояснения если что-то не так сделано")
                        .protectContent(true)
                        .build();
            }
            case SEVENTH -> {
                list = new ArrayList<>(
                        Arrays.asList("Неправильный ответ", "Правильный ответ", "Почти правильный ответ", "Неправильный ответ"));
                sendPoll = SendPoll.builder()
                        .chatId(response.getUserID().toString())
                        .question("Опрос №7")
                        .isAnonymous(Boolean.FALSE)
                        .options(list)
                        .type("quiz")
                        .correctOptionId(1)
                        .explanation("тут пояснения если что-то не так сделано")
                        .protectContent(true)
                        .build();
            }
            case EIGHT -> {
                list = new ArrayList<>(
                        Arrays.asList("Неправильный ответ", "Правильный ответ", "Почти правильный ответ", "Неправильный ответ"));
                sendPoll = SendPoll.builder()
                        .chatId(response.getUserID().toString())
                        .question("Опрос №8")
                        .isAnonymous(Boolean.FALSE)
                        .options(list)
                        .type("quiz")
                        .correctOptionId(1)
                        .explanation("тут пояснения если что-то не так сделано")
                        .protectContent(true)
                        .build();
            }
            case NINTH -> {
                list = new ArrayList<>(
                        Arrays.asList("Неправильный ответ", "Правильный ответ", "Почти правильный ответ", "Неправильный ответ"));
                sendPoll = SendPoll.builder()
                        .chatId(response.getUserID().toString())
                        .question("Опрос №9")
                        .isAnonymous(Boolean.FALSE)
                        .options(list)
                        .type("quiz")
                        .correctOptionId(1)
                        .explanation("тут пояснения если что-то не так сделано")
                        .protectContent(true)
                        .build();
            }
        }
        return sendPoll;
    }
}
