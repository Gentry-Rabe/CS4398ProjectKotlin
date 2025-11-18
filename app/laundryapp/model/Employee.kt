package com.laundryapp.model;

import java.util.List;

public class Employee {
    private int employeeId;
    private String name;
    private String email;
    private String passwordHash;
    private PaymentInfo payAccount;
    private double rating;
    private List<Job> acceptedJobs;

    // Constructors
    public Employee() {}

    public Employee(int employeeId, String name, String email, String passwordHash) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    // Method definitions (to be implemented)

    @Override
    public String toString() {
        return "Employee ID: " + employeeId + ", Name: " + name + ", Email: " + email + ", Rating: " + rating;
    }

    public void register() {
        System.out.println("Employee " + name + " registered successfully.");
    }

    public void acceptJob(Job job) {
        if (acceptedJobs != null) {
            acceptedJobs.add(job);
        }

        job.assignEmployee(this);
        job.updateStatus(JobStatus.ACCEPTED);
    }

    public void updateProfile() {
        System.out.println("Employee profile updated for: " + name);
    }

    public void blockUser(UserAccount user) {
        System.out.println("Employee " + name + " has blocked user: " + user.getName());
    }

    public void rateUser(UserAccount user, double rating) {
        user.setRating(rating);
    }

    public void updateJobStatus(Job job, JobStatus status) {
    job.updateStatus(status);
    }

    // Getters and Setters
    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }

    public PaymentInfo getPayAccount() { return payAccount; }
    public void setPayAccount(PaymentInfo payAccount) { this.payAccount = payAccount; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    public List<Job> getAcceptedJobs() { return acceptedJobs; }
    public void setAcceptedJobs(List<Job> acceptedJobs) { this.acceptedJobs = acceptedJobs; }
}
