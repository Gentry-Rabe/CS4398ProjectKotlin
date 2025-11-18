package com.laundryapp.model;

public class PaymentInfo {
    private String accountNumber;
    private String bankName;
    private String routingNumber;
    private double balance;

    // Constructors
    public PaymentInfo() {}

    public PaymentInfo(String accountNumber, String bankName, String routingNumber, double balance) {
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.routingNumber = routingNumber;
        this.balance = balance;
    }

    // Method definitions (to be implemented)
    public void deposit(double amount) {
        this.balance += amount;
    }
    public void withdraw(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
        }
    }
    public void refund(double amount) {
        this.balance += amount;
    }

    // Getters and Setters
    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public String getBankName() { return bankName; }
    public void setBankName(String bankName) { this.bankName = bankName; }

    public String getRoutingNumber() { return routingNumber; }
    public void setRoutingNumber(String routingNumber) { this.routingNumber = routingNumber; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
}
