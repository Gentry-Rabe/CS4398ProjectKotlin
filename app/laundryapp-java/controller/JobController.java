package com.laundryapp.controller;

import com.laundryapp.model.Job;
import com.laundryapp.model.Employee;
import com.laundryapp.model.UserAccount;
import com.laundryapp.model.JobStatus;
import com.laundryapp.service.PaymentSystem;
import com.laundryapp.service.RatingSystem;

import java.util.List;

public class JobController {
    private List<Job> jobs;
    private PaymentSystem paymentSystem;
    private RatingSystem ratingSystem;

    public JobController(List<Job> jobs, PaymentSystem paymentSystem, RatingSystem ratingSystem) {
        this.jobs = jobs;
        this.paymentSystem = paymentSystem;
        this.ratingSystem = ratingSystem;
    }

    // CRUD operations
    public void createJob(Job job) {
        jobs.add(job);
    }

    public void updateJobStatus(Job job, JobStatus status) {
        job.updateStatus(status);
    }

    public void assignJob(Job job, Employee employee) {
        job.assignEmployee(employee);
        job.updateStatus(JobStatus.ACCEPTED);
        employee.acceptJob(job);
    }

    public void completeJob(Job job) {
        job.updateStatus(JobStatus.COMPLETED);
        paymentSystem.processPayment(job.getUser(), job.getEmployee(), job.getPrice());
    }

    public void refundJob(Job job) {
        job.updateStatus(JobStatus.REFUNDED);
        paymentSystem.refundPayment(job.getUser(), job.getPrice());
    }

    // Utility
    public List<Job> getAllJobs() {
        return jobs;
    }
}
