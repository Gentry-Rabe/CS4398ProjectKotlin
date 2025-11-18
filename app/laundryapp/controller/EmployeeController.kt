package com.laundryapp.controller

import com.laundryapp.model.Employee
import com.laundryapp.model.Job
import com.laundryapp.model.JobStatus
import com.laundryapp.service.PaymentSystem
import com.laundryapp.service.RatingSystem

class EmployeeController(
    employees: MutableList<Employee?>,
    paymentSystem: PaymentSystem,
    ratingSystem: RatingSystem
) {
    private val employees: MutableList<Employee?>
    private val paymentSystem: PaymentSystem
    private val ratingSystem: RatingSystem

    init {
        this.employees = employees
        this.paymentSystem = paymentSystem
        this.ratingSystem = ratingSystem
    }

    // CRUD operations
    fun registerEmployee(employee: Employee?) {
        employees.add(employee)
    }

    fun updateEmployee(employee: Employee?) {
        // Implementation for updating employee info
    }

    fun deleteEmployee(employee: Employee?) {
        employees.remove(employee)
    }

    // Job-related methods
    fun acceptJob(employee: Employee, job: Job?) {
        employee.acceptJob(job)
    }

    fun updateJobStatus(employee: Employee, job: Job?, status: JobStatus?) {
        employee.updateJobStatus(job, status)
    }

    // Ratings
    fun rateUser(employee: Employee?, targetEmployee: Employee?, rating: Double) {
        ratingSystem.rateEmployee(targetEmployee, rating)
    }

    fun calculatePay(employee: Employee?) {
        paymentSystem.calculatePay(employee)
    }

    val allEmployees: MutableList<Employee>
        // Utility
        get() = employees
}