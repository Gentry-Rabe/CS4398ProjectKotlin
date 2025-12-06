package com.laundryapp.controller

import com.laundryapp.model.Job
import com.laundryapp.model.Employee
import com.laundryapp.model.UserAccount
import com.laundryapp.model.JobStatus
import com.laundryapp.service.PaymentSystem
import com.laundryapp.service.RatingSystem

class JobController(
    jobs: MutableList<Job?>,
    paymentSystem: PaymentSystem,
    ratingSystem: RatingSystem?
) {
    private val jobs: MutableList<Job?>
    private val paymentSystem: PaymentSystem
    private val ratingSystem: RatingSystem?

    init {
        this.jobs = jobs
        this.paymentSystem = paymentSystem
        this.ratingSystem = ratingSystem
    }

    // CRUD operations
    fun createJob(job: Job?) {
        jobs.add(job)
    }

    fun updateJobStatus(job: Job, status: JobStatus?) {
        job.updateStatus(status)
    }

    fun assignJob(job: Job, employee: Employee) {
        job.assignEmployee(employee)
        job.updateStatus(JobStatus.ACCEPTED)
        employee.acceptJob(job)
    }

    fun completeJob(job: Job) {
        job.updateStatus(JobStatus.COMPLETED)
        paymentSystem.processPayment(job.getUser(), job.getEmployee(), job.getPrice())
    }

    fun refundJob(job: Job) {
        job.updateStatus(JobStatus.REFUNDED)
        paymentSystem.refundPayment(job.getUser(), job.getPrice())
    }

    val allJobs: MutableList<Job>
        // Utility
        get() = jobs
}