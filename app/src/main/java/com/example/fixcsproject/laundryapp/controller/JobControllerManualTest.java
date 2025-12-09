package com.example.fixcsproject.laundryapp.controller;

import com.example.fixcsproject.laundryapp.controller.JobController;
import com.example.fixcsproject.laundryapp.model.Job;
import com.example.fixcsproject.laundryapp.model.Employee;
import com.example.fixcsproject.laundryapp.model.UserAccount;
import com.example.fixcsproject.laundryapp.model.JobStatus;
import com.example.fixcsproject.laundryapp.service.PaymentSystem;
import com.laundryapp.service.RatingSystem;

import java.util.ArrayList;
import java.util.List;

public class JobControllerManualTest {

    public static void main(String[] args) {
        System.out.println("=== com.example.fixcsproject.laundryapp.controller.JobController Manual Tests ===");

        // Setup
        List<Job> jobs = new ArrayList<>();
        PaymentSystem paymentSystem = new PaymentSystem();
        RatingSystem ratingSystem = new RatingSystem();

        JobController controller =
                new JobController(jobs, paymentSystem, ratingSystem);

        Employee employee = new Employee(1, "Ricky", "r@email.com", "pass");
        UserAccount user = new UserAccount();
        user.setUserId("user1");

        Job job = new Job(1, "Laundry", "Austin", 25.0);
        job.setUser(user);

        // Test createJob
        controller.createJob(job);
        System.out.println("Create job works: " +
                (controller.getAllJobs().size() == 1));

        // Test assignJob
        controller.assignJob(job, employee);
        System.out.println("Assign job sets employee: " +
                (job.getEmployee() == employee));
        System.out.println("Assign job sets status ACCEPTED: " +
                (job.getStatus() == JobStatus.ACCEPTED));

        // Test updateJobStatus
        controller.updateJobStatus(job, JobStatus.IN_PROGRESS);
        System.out.println("Update job status works: " +
                (job.getStatus() == JobStatus.IN_PROGRESS));

        // Test completeJob
        controller.completeJob(job);
        System.out.println("Complete job sets status COMPLETED: " +
                (job.getStatus() == JobStatus.COMPLETED));

        // Test refundJob
        controller.refundJob(job);
        System.out.println("Refund job sets status REFUNDED: " +
                (job.getStatus() == JobStatus.REFUNDED));

        System.out.println("=== com.example.fixcsproject.laundryapp.controller.JobController Manual Tests Finished ===");
    }
}
