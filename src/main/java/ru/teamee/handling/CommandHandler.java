package ru.teamee.handling;

import org.telegram.telegrambots.meta.api.objects.polls.PollAnswer;
import ru.teamee.bots.*;
import ru.teamee.bots.responses.*;


import java.util.HashMap;
import java.util.Objects;

public class CommandHandler implements Handler {
    private final User user;
    private final HashMap<String, Integer> mapWithRightAnswers;

    public CommandHandler(User user, HashMap<String, Integer> mapWithRightAnswers) {
        this.user = user;
        this.mapWithRightAnswers = mapWithRightAnswers;
    }

    @Override
    public Response handleRequest(Request request) {
        Long userID = request.getUserID();
        String message = request.getMessage();
        var pollAnswer = request.getPollAnswer();
        var usersMap = user.getUsersHashMap();

        if (request.getMessage().startsWith("/start")) {
            user.addUserData(userID, usersMap);
            return new ResponseWithStartBot(userID);      // ResponseWithQuizStart
        }
        if (request.getMessage().startsWith("/quiz")) {
            for (Long key: usersMap.keySet())
            {
                if(Objects.equals(userID, key)) {

                    HashMap<String, Boolean> value = usersMap.get(key);
                    value.remove("isQuizRunning");
                    value.put("isQuizRunning", true);

                }
            }

            return new ResponseWithQuizStart(userID);      // ResponseWithQuizStart
        }
        for (Long key: usersMap.keySet())
        {
            if(Objects.equals(userID, key)) {

                HashMap<String, Boolean> value = usersMap.get(key);
                Boolean isQuizRunning = value.get("isQuizRunning");
                if (isQuizRunning) {
                    return handleRunningQuiz(message, userID, pollAnswer, mapWithRightAnswers);  // ResponseWithUnfinishedQuiz и ResponseOnPoll
                }
            }
        }


        return new ResponseWithEcho(request.getMessage(), userID);    // ResponseWithEcho
    }

    private Response handleRunningQuiz(String message, Long userID, PollAnswer pollAnswer,
                                       HashMap<String, Integer> mapWithRightAnswers) {
        if (message != null && pollAnswer == null) {
            String finishQuizFirstMessage = "You must finish Quiz first";
            return new ResponseWithUnfinishedQuiz(finishQuizFirstMessage, userID) ;
        }

        int usersChosenID = pollAnswer.getOptionIds().get(0);
        int correctAnswerID = mapWithRightAnswers.get(pollAnswer.getPollId());
        if (usersChosenID == correctAnswerID) {
            System.out.println("Right answer was chosen");
        }
        else {
            System.out.println("Wrong answer was chosen");
        }
        mapWithRightAnswers.remove(pollAnswer.getPollId());
        return new ResponseOnPollAnswer(userID, mapWithRightAnswers.isEmpty());
    }
}
