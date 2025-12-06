package com.laundryapp.controller;

import com.laundryapp.model.UserAccount;
import com.laundryapp.service.PaymentSystem;
import com.laundryapp.service.RatingSystem;

import java.util.ArrayList;
import java.util.List;

public class UserControllerManualTest {

    public static void main(String[] args) {
        System.out.println("=== UserController Manual Tests ===");

        List<UserAccount> users = new ArrayList<>();
        PaymentSystem paymentSystem = new PaymentSystem();
        RatingSystem ratingSystem = new RatingSystem();

        UserController controller =
                new UserController(users, paymentSystem, ratingSystem);

        UserAccount user = new UserAccount();

        // Test registerUser
        controller.registerUser(user);
        System.out.println("Register user works: " +
                (controller.getAllUsers().size() == 1));

        // Test deleteUser
        controller.deleteUser(user);
        System.out.println("Delete user works: " +
                (controller.getAllUsers().isEmpty()));

        System.out.println("=== UserController Manual Tests Finished ===");
    }
}
