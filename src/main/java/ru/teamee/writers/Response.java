package ru.teamee.writers;

public class Response {
    private final String answer;
    private final Long userID;
    public Response(String answer) {
        this.answer = answer;
        this.userID = null;
    }
    public Response(String answer, Long userID) {
        this.answer = answer;
        this.userID = userID;
    }
    public String getAnswer() {
        return answer;
    }

    public Long getUserID() {
        return userID;
    }
}
