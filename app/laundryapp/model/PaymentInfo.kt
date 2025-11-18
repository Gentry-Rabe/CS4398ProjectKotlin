package com.laundryapp.model

class PaymentInfo {
    // Getters and Setters
    var accountNumber: String? = null
    var bankName: String? = null
    var routingNumber: String? = null
    var balance: Double = 0.0

    // Constructors
    constructor()

    constructor(
        accountNumber: String?,
        bankName: String?,
        routingNumber: String?,
        balance: Double
    ) {
        this.accountNumber = accountNumber
        this.bankName = bankName
        this.routingNumber = routingNumber
        this.balance = balance
    }

    // Method definitions (to be implemented)
    fun deposit(amount: Double) {
        this.balance += amount
    }

    fun withdraw(amount: Double) {
        if (this.balance >= amount) {
            this.balance -= amount
        }
    }

    fun refund(amount: Double) {
        this.balance += amount
    }
}