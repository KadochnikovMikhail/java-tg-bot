package ru.teamee.handling;

import org.telegram.telegrambots.meta.api.objects.polls.PollAnswer;
import ru.teamee.bots.*;
import ru.teamee.bots.responses.*;



public class CommandHandler implements Handler {
    private final User user;

    public CommandHandler(User user) {
        this.user = user;
    }

    @Override
    public Response handleRequest(Request request) {
        Long userID = request.getUserID();
        String message = request.getMessage();
        var pollAnswer = request.getPollAnswer();
        if (user.isThisUserNew(userID)) {
            user.putNewUserOnMap(userID);
        }
        if (user.isUsersQuizRunning(userID)) {
            return handleRunningQuiz(message, userID, pollAnswer);
        }

        if (message.startsWith("/quiz")) {
            user.startQuizForUser(userID);
            return new ResponseWithQuizStart(userID);      // ResponseWithQuizStart
        }
        return new ResponseWithEcho(request.getMessage(), userID);    // ResponseWithEcho
    }

    private Response handleRunningQuiz(String message, Long userID, PollAnswer pollAnswer) {
        if (message != null && pollAnswer == null) {
            String finishQuizFirstMessage = "You must finish Quiz first";
            return new ResponseWithUnfinishedQuiz(finishQuizFirstMessage, userID) ;
        }
//        if you will need to incorporate some logic with right/false answers, then it should be done here
//
//        int usersChosenID = pollAnswer.getOptionIds().get(0);
//        int correctAnswerID = mapWithRightAnswers.get(pollAnswer.getPollId());
//        if (usersChosenID == correctAnswerID) {
//            System.out.println("Right answer was chosen");
//        }
//        else {
//            System.out.println("Wrong answer was chosen");
//        }
        user.noteQuizAnswer(userID, pollAnswer.getPollId());
        boolean isFinished = user.isPollFinishedForUser(userID);
        return new ResponseOnPollAnswer(userID, isFinished);
    }
}
