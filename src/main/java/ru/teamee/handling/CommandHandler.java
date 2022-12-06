package ru.teamee.handling;

import org.telegram.telegrambots.meta.api.objects.polls.PollAnswer;
import ru.teamee.bots.*;
import ru.teamee.bots.responses.*;

import java.util.HashMap;

public class CommandHandler implements Handler {
    @Override
    public Response handleRequest(Request request) {
        Long userID = request.getUserID();
        String message = request.getMessage();
        var pollAnswer = request.getPollAnswer();
        var map = request.getMapWithRightAnswers();
        boolean isQuizRunning = request.isQuizRunning();
        if (isQuizRunning) {
            return handleRunningQuiz(message, userID, pollAnswer, map);  // ResponseWithUnfinishedQuiz и ResponseOnPoll
        }
        if (request.getMessage().startsWith("/quiz")) {
            return new ResponseWithQuizStart(userID);      // ResponseWithQuizStart
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
