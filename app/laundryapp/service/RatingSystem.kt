package com.laundryapp.service

import com.laundryapp.model.Employee
import com.laundryapp.model.UserAccount

class RatingSystem {
    fun rateUser(user: UserAccount, rating: Double) {
        user.setRating(rating)
        println("Rated user " + user.getName() + " with rating: " + rating)
    }

    fun rateEmployee(employee: Employee, rating: Double) {
        employee.setRating(rating)
        println("Rated employee " + employee.getName() + " with rating: " + rating)
    }

    fun calculateAverageRating(ratings: MutableList<Double?>?): Double {
        if (ratings == null || ratings.isEmpty()) {
            return 0.0
        }

        var sum = 0.0
        for (r in ratings) {
            sum += r!!
        }

        return sum / ratings.size
    }
}
