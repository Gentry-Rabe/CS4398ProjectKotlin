package com.laundryapp.controller;

import com.laundryapp.model.*;
import com.laundryapp.service.*;
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
    public void updateUser(UserAccount user) {}
    public void deleteUser(UserAccount user) { users.remove(user); }
}
