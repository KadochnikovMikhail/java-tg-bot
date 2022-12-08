package ru.teamee.bots;


import java.util.HashMap;

public class User {
    private HashMap<String, Boolean> singleUserHashMap;

    private final HashMap<Long, HashMap<String, Boolean> > usersHashMap;



    public User(HashMap<Long, HashMap<String, Boolean>> usersHashMap) {
        this.usersHashMap = usersHashMap;
   }

    public void addUserData(Long userID,  HashMap<Long, HashMap<String, Boolean>> usersHashMap) {
        singleUserHashMap.put("isQuizRunning", false);
        usersHashMap.put(userID, singleUserHashMap);
    }

    public HashMap<Long, HashMap<String, Boolean>> getUsersHashMap() {
        return usersHashMap;
    }

}
