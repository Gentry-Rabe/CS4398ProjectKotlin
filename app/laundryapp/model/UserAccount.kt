package com.laundryapp.model

class UserAccount {
    // Getters and Setters
    var userId: Int = 0
    var name: String? = null
    var email: String? = null
    var passwordHash: String? = null
    var location: String? = null
    private var paymentInfo: PaymentInfo? = null

    // Constructors
    constructor()

    constructor(
        userId: Int,
        name: String?,
        email: String?,
        passwordHash: String?,
        location: String?
    ) {
        this.userId = userId
        this.name = name
        this.email = email
        this.passwordHash = passwordHash
        this.location = location
    }

    // Method definitions (to be implemented)
    fun register() {}
    fun login() {}
    fun updateProfile() {}
    fun deleteAccount() {}
    fun postJob(job: Job?) {}
    fun rateEmployee(employee: Employee?, rating: Double) {}
    fun requestEmployee(employee: Employee?) {}
    fun blockEmployee(employee: Employee?) {}
    fun bookmarkEmployee(employee: Employee?) {}

    fun getPaymentInfo(): PaymentInfo? {
        return paymentInfo
    }

    fun setPaymentInfo(paymentInfo: PaymentInfo?) {
        this.paymentInfo = paymentInfo
    }
}