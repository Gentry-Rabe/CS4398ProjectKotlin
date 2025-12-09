package com.example.fixcsproject.ui.login;

import com.example.fixcsproject.laundryapp.model.UserAccount;

import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
    private static UserDatabase instance;
    private List<UserAccount> userList;
    private UserAccount sessionUser;

    private UserDatabase() {
        userList = new ArrayList<>();
        sessionUser = null;
    }

    public static synchronized UserDatabase getInstance() {
        if (instance == null) {
            instance = new UserDatabase();
        }
        return instance;
    }

    public void addUser(UserAccount user) {
        userList.add(user);
    }

    public List<UserAccount> getAllUsers() {
        return userList;
    }

    public UserAccount getSessionUser() {
        return sessionUser;
    }

    public void setSessionUser(UserAccount user) {
        this.sessionUser = user;
    }

    public void clearSession() {
        this.sessionUser = null;
    }
}
