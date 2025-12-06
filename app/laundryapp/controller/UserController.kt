package com.laundryapp.controller

import com.laundryapp.model.*
import com.laundryapp.service.*

class UserController(
    users: MutableList<UserAccount?>,
    paymentSystem: PaymentSystem?,
    ratingSystem: RatingSystem?
) {
    private val users: MutableList<UserAccount?>
    private val paymentSystem: PaymentSystem?
    private val ratingSystem: RatingSystem?

    init {
        this.users = users
        this.paymentSystem = paymentSystem
        this.ratingSystem = ratingSystem
    }

    fun registerUser(user: UserAccount?) {
        users.add(user)
    }

    fun updateUser(user: UserAccount?) {}
    fun deleteUser(user: UserAccount?) {
        users.remove(user)
    }
}