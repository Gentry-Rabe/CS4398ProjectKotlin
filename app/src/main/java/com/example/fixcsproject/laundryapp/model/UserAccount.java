package com.example.fixcsproject.laundryapp.model;

import com.example.fixcsproject.laundryapp.model.PaymentInfo;

import java.util.List;

public class UserAccount {
    private String userId;
    private String name;
    private String email;
    private String passwordHash;
    private String location;
    private PaymentInfo paymentInfo;
    private List<Job> jobs;
    private double rating;

    public UserAccount(String userId, String name, String email, String passwordHash, String location,
    PaymentInfo paymentInfo, List<Job> jobs) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
        this.location = location;
        this.paymentInfo = paymentInfo;
        this.jobs = jobs;
    }

    public UserAccount() {}

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public void addJob(Job job) {
        this.jobs.add(job);
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", location='" + location + '\'' +
                ", paymentInfo=" + paymentInfo +
                ", jobsCount=" + (jobs != null ? jobs.size() : 0) +
        '}';
    }

    public void setRating(double rating) {this.rating = rating;}

    public double getRating() {return rating;}
}
