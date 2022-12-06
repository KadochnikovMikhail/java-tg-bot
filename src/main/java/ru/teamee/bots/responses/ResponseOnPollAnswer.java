package ru.teamee.bots.responses;


public class ResponseOnPollAnswer extends Response {
    private final boolean isQuizFinished;
    public ResponseOnPollAnswer(Long userID, boolean isFinished) {
        super(null, userID, null);
        isQuizFinished = isFinished;
    }

    public boolean isQuizFinished() {
        return isQuizFinished;
    }
}
