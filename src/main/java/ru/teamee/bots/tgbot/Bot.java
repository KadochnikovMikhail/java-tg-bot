package ru.teamee.bots.tgbot;

import org.telegram.telegrambots.meta.api.methods.polls.SendPoll;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.teamee.bots.*;
import ru.teamee.handling.CommandHandler;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.HashMap;
import java.util.Objects;


/* Primary Telegram Bot class (we're using LongPolling technology)
 * and this class implements Writer interface */
public class Bot extends TelegramLongPollingBot implements Writer {
    private final String botToken;
    private final String botName;
    private final CommandHandler handler;
    private final HashMap<String, Integer> quizIdMap;
    private final Converter converter;
    private boolean isQuizRunning = false;

    public Bot(String botName, String botToken) {
        this.quizIdMap = new HashMap<>();
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
            if (isQuizRunning) {
                Request request = converter.makeRequestFromUpdate(update);
                Response unfinishedQuizResponse = handler.makeUnfinishedQuizResponse(request);
                write(unfinishedQuizResponse);
            } else {
                Request request = converter.makeRequestFromUpdate(update);
                Response response = handler.handleRequest(request);
                write(response);
            }
        } else if (update.hasPollAnswer()) {
            Request request = converter.makeQuizAnswerRequestFromUpdate(update, quizIdMap);
            isQuizRunning = handler.handleQuizAnswerRequest(request);
        }   // сделать так, чтобы данные с опроса сохранялись и мы могли посмотреть, на какие вопросы ответил юзер
    }

    // Methods writes response to user's telegram chat
    @Override
    public void write(Response response) {
        try {
            if (Objects.equals(response.getAnswer(), "/quiz")) {
                writeQuiz(response);
            }
            else {
                SendMessage sm = converter.makeMessageFromResponse(response);
                execute(sm);
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void writeQuiz(Response response) {
        try {
            for (SimpleQuizEnum number : SimpleQuizEnum.values()) {
                SendPoll sp = converter.makeQuizFromResponse(response, number);
                Message poll = execute(sp);
                quizIdMap.put(poll.getPoll().getId(), poll.getPoll().getCorrectOptionId());
            }
            isQuizRunning = true;
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}

