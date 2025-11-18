package com.laundryapp.model

class Job {
    // Getters and Setters
    var jobId: Int = 0
    var description: String? = null
    var location: String? = null
    var price: Double = 0.0
    private var status: JobStatus? = null
    private var user: UserAccount? = null
    private var employee: Employee? = null

    // Constructors
    constructor()

    constructor(jobId: Int, description: String?, location: String?, price: Double) {
        this.jobId = jobId
        this.description = description
        this.location = location
        this.price = price
        this.status = JobStatus.PENDING
    }

    // Method definitions (to be implemented)
    fun assignEmployee(employee: Employee?) {
        this.employee = employee
    }

    fun updateStatus(newStatus: JobStatus?) {
        this.status = newStatus
    }

    fun notifyUser() {
        println("User has been notified about job update.")
    }

    fun completeJob() {}
    fun refundUser() {}

    override fun toString(): String {
        return "Job ID: " + jobId + ", Status: " + status + ", Price: " + price
    }


    fun getStatus(): JobStatus? {
        return status
    }

    fun setStatus(status: JobStatus?) {
        this.status = status
    }

    fun getUser(): UserAccount? {
        return user
    }

    fun setUser(user: UserAccount?) {
        this.user = user
    }

    fun getEmployee(): Employee? {
        return employee
    }

    fun setEmployee(employee: Employee?) {
        this.employee = employee
    }
}