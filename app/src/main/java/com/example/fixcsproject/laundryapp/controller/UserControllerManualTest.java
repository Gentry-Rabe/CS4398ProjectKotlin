package com.example.fixcsproject.laundryapp.controller;

import com.example.fixcsproject.laundryapp.controller.UserController;
import com.example.fixcsproject.laundryapp.model.UserAccount;
import com.example.fixcsproject.laundryapp.service.PaymentSystem;
import com.laundryapp.service.RatingSystem;

import java.util.ArrayList;
import java.util.List;

public class UserControllerManualTest {

    public static void main(String[] args) {
        System.out.println("=== com.example.fixcsproject.laundryapp.controller.UserController Manual Tests ===");

        List<UserAccount> users = new ArrayList<>();
        PaymentSystem paymentSystem = new PaymentSystem();
        RatingSystem ratingSystem = new RatingSystem();

        UserController controller =
                new UserController(users, paymentSystem, ratingSystem);

        UserAccount user = new UserAccount();
        user.setUserId("user1");

        // Test registerUser
        controller.registerUser(user);
        System.out.println("Register user works: " +
                (controller.getAllUsers().size() == 1));

        // Test deleteUser
        controller.deleteUser(user);
        System.out.println("Delete user works: " +
                (controller.getAllUsers().isEmpty()));

        System.out.println("=== com.example.fixcsproject.laundryapp.controller.UserController Manual Tests Finished ===");
    }
}
