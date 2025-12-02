package com.example.fixcsproject;

import com.example.fixcsproject.laundryapp.model.Employee;
import com.example.fixcsproject.laundryapp.model.UserAccount;
import com.example.fixcsproject.laundryapp.model.PaymentInfo;
import com.example.fixcsproject.laundryapp.service.RatingSystem;

import org.junit.Test;
import static org.junit.Assert.*;

public class RatingSystemTest {

    @Test
    public void testRateEmployeeUpdatesRating() {
        Employee emp = new Employee(10, "Jane", "e@a.com", "pass");
        RatingSystem ratingSystem = new RatingSystem();

        ratingSystem.rateEmployee(emp, 4.5);

        assertEquals(4.5, emp.getRating(), 0.001);
    }

    @Test
    public void testCalculateAverageRating() {
        RatingSystem ratingSystem = new RatingSystem();

        java.util.List<Double> ratings =
                java.util.Arrays.asList(5.0, 4.0, 3.0);

        double avg = ratingSystem.calculateAverageRating(ratings);

        assertEquals(4.0, avg, 0.001);
    }
}
