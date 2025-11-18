package com.laundryapp.model;

import java.util.List;

public class UserAccount {
    private int userId;
    private String name;
    private String email;
    private String passwordHash;
    private String location;
    private PaymentInfo paymentInfo;

    // Constructors
    public UserAccount() {}

    public UserAccount(int userId, String name, String email, String passwordHash, String location) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
        this.location = location;
    }

    // Method definitions (to be implemented)
    public void register() {}
    public void login() {}
    public void updateProfile() {}
    public void deleteAccount() {}
    public void postJob(Job job) {}
    public void rateEmployee(Employee employee, double rating) {}
    public void requestEmployee(Employee employee) {}
    public void blockEmployee(Employee employee) {}
    public void bookmarkEmployee(Employee employee) {}

    // Getters and Setters
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public PaymentInfo getPaymentInfo() { return paymentInfo; }
    public void setPaymentInfo(PaymentInfo paymentInfo) { this.paymentInfo = paymentInfo; }
}
