package ru.teamee.bots;


import java.util.HashMap;

public class User {
    private final HashMap<Long, Boolean> usersQuizStatusMap;
    private final HashMap<Long, HashMap<String, Boolean>> usersQuizProgress;
    private final HashMap<Long, HashMap<String, Integer>> mapWithRightPollAnswers;

    public User() {
        this.usersQuizStatusMap = new HashMap<>();
        this.usersQuizProgress = new HashMap<>();
        this.mapWithRightPollAnswers = new HashMap<>();
    }

    public void putNewUserOnMap(long userID) {
        if (!usersQuizStatusMap.containsKey(userID)) {
            usersQuizStatusMap.put(userID, false);
        }
    }

    public boolean isUsersQuizRunning(long userID) {
        return usersQuizStatusMap.get(userID);
    }

    private void finishUsersPoll(long userID) {
        mapWithRightPollAnswers.remove(userID);
        usersQuizStatusMap.put(userID, false);
        usersQuizProgress.remove(userID);
        System.out.println("changing");
    }

    public void setMapWithRightPollAnswers(long userID, HashMap<String, Integer> mapWithRightPollAnswers) {
        this.mapWithRightPollAnswers.put(userID, mapWithRightPollAnswers);
        HashMap<String, Boolean> mapWithAnswers = fillQuizAnswersMapWithFalse(mapWithRightPollAnswers);
        usersQuizProgress.put(userID, mapWithAnswers);
    }

    public void noteQuizAnswer(long userID, String pollID) {
        var usersMap = usersQuizProgress.get(userID);
        usersMap.remove(pollID);
        if (usersMap.isEmpty()) {
            finishUsersPoll(userID);
        }
    }

    public boolean isThisUserNew(long userID) {
        return !usersQuizStatusMap.containsKey(userID);
    }

    public boolean isPollFinishedForUser(long userID) {
        return usersQuizProgress.get(userID).isEmpty();
    }

    public void startQuizForUser(long userID) {
        usersQuizStatusMap.put(userID, true);
    }

    private HashMap<String, Boolean> fillQuizAnswersMapWithFalse(HashMap<String, Integer> mapWithRightAnswers) {
        HashMap<String, Boolean> map = new HashMap<>();
        for (String pollID: mapWithRightAnswers.keySet()) {
            map.put(pollID, false);
        }
        return map;
    }

}
