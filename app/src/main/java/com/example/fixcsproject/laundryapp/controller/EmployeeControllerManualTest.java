package com.example.fixcsproject.laundryapp.controller;

import com.example.fixcsproject.laundryapp.controller.EmployeeController;
import com.example.fixcsproject.laundryapp.model.Employee;
import com.example.fixcsproject.laundryapp.model.Job;
import com.example.fixcsproject.laundryapp.model.JobStatus;
import com.example.fixcsproject.laundryapp.service.PaymentSystem;
import com.laundryapp.service.RatingSystem;

import java.util.ArrayList;
import java.util.List;

public class EmployeeControllerManualTest {

    public static void main(String[] args) {
        System.out.println("=== com.example.fixcsproject.laundryapp.controller.EmployeeController Manual Tests ===");

        List<Employee> employees = new ArrayList<>();
        PaymentSystem paymentSystem = new PaymentSystem();
        RatingSystem ratingSystem = new RatingSystem();

        EmployeeController controller =
                new EmployeeController(employees, paymentSystem, ratingSystem);

        // Test registerEmployee
        Employee emp = new Employee(1, "Ricky", "r@email.com", "pass");
        controller.registerEmployee(emp);
        System.out.println("Register employee: " +
                (controller.getAllEmployees().size() == 1));

        // Test acceptJob
        Job job = new Job(1, "Laundry", "Austin", 25.0);
        controller.acceptJob(emp, job);
        System.out.println("Accept job status correct: " +
                (job.getStatus() == JobStatus.ACCEPTED));

        // Test updateJobStatus
        controller.updateJobStatus(emp, job, JobStatus.IN_PROGRESS);
        System.out.println("Update job status works: " +
                (job.getStatus() == JobStatus.IN_PROGRESS));

        // Test rateEmployee
        controller.rateUser(emp, emp, 4.5);
        System.out.println("Rate employee works: " +
                (emp.getRating() == 4.5));

        System.out.println("=== Manual Tests Finished ===");
    }
}
