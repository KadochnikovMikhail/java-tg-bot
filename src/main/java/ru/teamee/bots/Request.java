package ru.teamee.bots;



/* Class helps to store and prepare data from user's request for Handler */
public class Request {
    private final String message;
    private final Long userID;
    private final Boolean quizEnded;

    // Telegram bot constructor
    public Request(String message, Long userID, Boolean empty) {
        this.message = message;
        this.userID = userID;
        this.quizEnded = empty;
    }
    public Request(String message, Long userID) {
        this(message, userID, null);
    }

    // Console bot constructor
    public Request(String message) {
        this(message, null);
    }



//    public Request(String message, Long userID, )

    public String getMessage() {
        return message;
    }

    public Long getUserID() {
        return userID;
    }

    public Boolean getQuizEnded(){
        return quizEnded;
    }
}