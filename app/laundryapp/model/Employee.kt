package com.laundryapp.model

class Employee {
    // Getters and Setters
    var employeeId: Int = 0
    var name: String? = null
    var email: String? = null
    var passwordHash: String? = null
    private var payAccount: PaymentInfo? = null
    var rating: Double = 0.0
    private var acceptedJobs: MutableList<Job?>? = null

    // Constructors
    constructor()

    constructor(employeeId: Int, name: String?, email: String?, passwordHash: String?) {
        this.employeeId = employeeId
        this.name = name
        this.email = email
        this.passwordHash = passwordHash
    }

    // Method definitions (to be implemented)
    override fun toString(): String {
        return "Employee ID: " + employeeId + ", Name: " + name + ", Email: " + email + ", Rating: " + rating
    }

    fun register() {
        println("Employee " + name + " registered successfully.")
    }

    fun acceptJob(job: Job) {
        if (acceptedJobs != null) {
            acceptedJobs.add(job)
        }

        job.assignEmployee(this)
        job.updateStatus(JobStatus.ACCEPTED)
    }

    fun updateProfile() {
        println("Employee profile updated for: " + name)
    }

    fun blockUser(user: UserAccount) {
        println("Employee " + name + " has blocked user: " + user.getName())
    }

    fun rateUser(user: UserAccount, rating: Double) {
        user.setRating(rating)
    }

    fun updateJobStatus(job: Job, status: JobStatus?) {
        job.updateStatus(status)
    }

    fun getPayAccount(): PaymentInfo? {
        return payAccount
    }

    fun setPayAccount(payAccount: PaymentInfo?) {
        this.payAccount = payAccount
    }

    fun getAcceptedJobs(): MutableList<Job?>? {
        return acceptedJobs
    }

    fun setAcceptedJobs(acceptedJobs: MutableList<Job?>?) {
        this.acceptedJobs = acceptedJobs
    }
}