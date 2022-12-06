package ru.teamee.bots;

import org.telegram.telegrambots.meta.api.methods.polls.SendPoll;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.polls.PollAnswer;
import ru.teamee.bots.responses.Response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Converter {

    public SendMessage makeMessageFromResponse(Response response) {
        return SendMessage.builder()
                .chatId(response.getUserID().toString())
                .text(response.getMessage())
                .build();
    }

    /* Новый способ создания реквеста  */
    public Request convertUpdateIntoRequest(Update update, boolean isQuizRunning,
                                            HashMap<String, Integer> mapWithRightAnswers) {        // isQUizRunning и map заменить на сервис
        String message = update.hasMessage() ? update.getMessage().getText() : null;
        PollAnswer pollAnswer = update.hasPollAnswer() ? update.getPollAnswer() : null;
        Long userID = (message != null) ? update.getMessage().getFrom().getId() : update.getPollAnswer().getUser().getId();
        return new Request(message, userID, pollAnswer, isQuizRunning, mapWithRightAnswers);
    }

    public SendPoll makeQuizFromResponse(Response response, SimpleQuizEnum number) {
        SendPoll sendPoll = null;
        ArrayList<String> list;
        switch (number) {
            case FIRST -> {
                list = new ArrayList<>(
                        Arrays.asList("We suite a book at the spa resort for two",
                                "We suite a book for two at the spa resort ",
                                "We booked a suite at the spa resort for two",
                                "We booked a suite for two at the spa resort "));
                sendPoll = SendPoll.builder()
                        .chatId(response.getUserID().toString())
                        .question("Put the words in the correct order to make sentences.\n" +
                                "booked / a / we / suite / for / at / the / resort / spa / two")
                        .isAnonymous(Boolean.FALSE)
                        .options(list)
                        .type("quiz")
                        .correctOptionId(3)
                        .explanation("")
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
