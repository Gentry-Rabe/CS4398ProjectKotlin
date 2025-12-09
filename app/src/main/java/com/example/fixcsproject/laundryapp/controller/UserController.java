package com.example.fixcsproject.laundryapp.controller;

import com.example.fixcsproject.laundryapp.model.*;
import com.example.fixcsproject.laundryapp.service.PaymentSystem;
import com.laundryapp.service.*;

import java.util.Collection;
import java.util.List;

public class UserController {
    private List<UserAccount> users;
    private PaymentSystem paymentSystem;
    private RatingSystem ratingSystem;

    public UserController(List<UserAccount> users, PaymentSystem paymentSystem, RatingSystem ratingSystem) {
        this.users = users;
        this.paymentSystem = paymentSystem;
        this.ratingSystem = ratingSystem;
    }

    public void registerUser(UserAccount user) { users.add(user); }

    public void updateUser(UserAccount user, String username, String password, String email) {
        if (username != null && !username.isEmpty()) {
            user.setUsername(username);
        }
        if (password != null && !password.isEmpty()) {
            user.setPassword(password);
        }
        if (email != null && !email.isEmpty()) {
            user.setEmail(email);
        }
    }

    public void deleteUser(UserAccount user) { users.remove(user); }

    public UserAccount getUser(String username) {
        for (UserAccount user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public List<UserAccount> getAllUsers() { return users; }
}
