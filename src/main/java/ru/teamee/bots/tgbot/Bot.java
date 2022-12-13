package ru.teamee.bots.tgbot;

import org.telegram.telegrambots.meta.api.methods.polls.SendPoll;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.teamee.bots.*;
import ru.teamee.bots.responses.Response;
import ru.teamee.bots.responses.ResponseWithQuizStart;
import ru.teamee.handling.CommandHandler;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.HashMap;


/* Primary Telegram Bot class (we're using LongPolling technology)
 * and this class implements Writer interface */
public class Bot extends TelegramLongPollingBot implements Writer {
    private final String botToken;
    private final String botName;
    private final CommandHandler handler;
    private final Converter converter;

    private final User user;

    private final HashMap<String, Integer> mapWithRightPollAnswers;

    public Bot(String botName, String botToken) {
        this.mapWithRightPollAnswers = new HashMap<>();
        this.user = new User();                                                     // юзер инициализируется null =/
        this.handler = new CommandHandler(user);               // эта фигня инициализируется пустым словарем
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
        Request request = converter.convertUpdateIntoRequest(update);
        Response response = handler.handleRequest(request);
        write(response);
    }

    @Override
    public void write(Response response) {                                      // придумать нормальный фасад
        try {
            if (response instanceof ResponseWithQuizStart) {
                writeQuiz(response);
            } else {
                execute(converter.makeMessageFromResponse(response));
            }
//            } else if (response instanceof ResponseWithUnfinishedQuiz) {
//                execute(converter.makeMessageFromResponse(response));
//            } else if (response instanceof ResponseOnPollAnswer) {
//                execute(converter.makeMessageFromResponse(response));
//            } else {

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void writeQuiz(Response response) {
        try {
            for (SimpleQuizEnum enumNumber : SimpleQuizEnum.values()) {
                SendPoll sp = converter.makeQuizFromResponse(response, enumNumber);
                Message poll = execute(sp);
                mapWithRightPollAnswers.put(poll.getPoll().getId(), poll.getPoll().getCorrectOptionId());
                user.setMapWithRightPollAnswers(response.getUserID(), mapWithRightPollAnswers);
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}

