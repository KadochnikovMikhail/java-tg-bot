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
                        Arrays.asList("I prefer to cook my meals at home",
                                "I preferred cooking my meals at home",
                                "I prefer cooking meals at my home",
                                "I prefer cooking my meals at home"));
                sendPoll = SendPoll.builder()
                        .chatId(response.getUserID().toString())
                        .question("Put the words in the correct order to make sentences.\n" +
                                "I / cooking / at / meals / my / home / prefer")
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
                        Arrays.asList("Josh threw a party for surprise his sister last week",
                                "Josh threw a party for his sister last week to surprise",
                                "Josh threw surprise party for his sister last week",
                                "Josh threw a surprise party for his sister last week"));
                sendPoll = SendPoll.builder()
                        .chatId(response.getUserID().toString())
                        .question("Put the words in the correct order to make sentences.\n" +
                                "Josh / a / threw / for / surprise / his / last / sister / party / week")
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
                        Arrays.asList("You did leave the door open?",
                                "Did you leave the door open?",
                                "Did you left the door open?",
                                "Did you leave the door opened?"));
                sendPoll = SendPoll.builder()
                        .chatId(response.getUserID().toString())
                        .question("Put the words in the correct order to make sentences.\n" +
                                "you / the / door / open / leave / did?")
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
                        Arrays.asList("You could please tell me where the nearest pharmacy is?",
                                "Could you please tell me where the nearest pharmacy is?",
                                "Please, could you tell me where the nearest pharmacy is?",
                                "Could you please tell me the nearest pharmacy where is?"));
                sendPoll = SendPoll.builder()
                        .chatId(response.getUserID().toString())
                        .question("Put the words in the correct order to make sentences.\n" +
                                "please / could / tell / you / where / me / the / pharmacy / nearest /is?")
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
                        Arrays.asList("You are alright, you look kinda worried?",
                                "Are you alright, you look kinda worried?",
                                "Are you alright, look you kinda worried?",
                                "Are you alright, you kinda look worried?"));
                sendPoll = SendPoll.builder()
                        .chatId(response.getUserID().toString())
                        .question("""
                                Read the answers and try to come up with suitable questions for them. There is more than one option possible:
                                - ...
                                - Yes, I’m fine, just a little bit under the weather.
                                """)
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
                        Arrays.asList("Didn't come up to meeting a week ago?",
                                "Why you didn't come up to meeting a week ago?",
                                "Who you didn't come up to meeting a week ago?",
                                "Why you didn't came up to meeting a week ago?"));
                sendPoll = SendPoll.builder()
                        .chatId(response.getUserID().toString())
                        .question("""
                                Read the answers and try to come up with suitable questions for them. There is more than one option possible.
                                - ...
                                - I was grounded because my parents learnt I got a “C” for my Calculus final.
                                """)
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
                        Arrays.asList("Do you think, which one fits me better blue or red dress?",
                                "What do you think, which one fits me better blue or red dress?",
                                "What do you think, which one fits me better blue or red?",
                                "Which one fits me better blue or red dress?"));
                sendPoll = SendPoll.builder()
                        .chatId(response.getUserID().toString())
                        .question("""
                                Read the answers and try to come up with suitable questions for them. There is more than one option possible.
                                - ...
                                - I would go with the red dress. It suits you better than the blue one.
                                """)
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
                        Arrays.asList("Who was the 16th president of United States of America?",
                                "Am I a president?",
                                "Who is the 16th president of United States of America?",
                                "Where was the 16th president of United States of America?"));
                sendPoll = SendPoll.builder()
                        .chatId(response.getUserID().toString())
                        .question("""
                                Read the answers and try to come up with suitable questions for them. There is more than one option possible.
                                - ...
                                - I think it was Abraham Lincoln who abolished slavery in the USA.
                                """)
                        .isAnonymous(Boolean.FALSE)
                        .options(list)
                        .type("quiz")
                        .correctOptionId(0)
                        .explanation("тут пояснения если что-то не так сделано")
                        .protectContent(true)
                        .build();
            }
        }
        return sendPoll;
    }
}
