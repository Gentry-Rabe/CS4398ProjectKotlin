package com.laundryapp.controller;

import com.laundryapp.model.Employee;
import com.laundryapp.model.Job;
import com.laundryapp.model.JobStatus;
import com.laundryapp.service.PaymentSystem;
import com.laundryapp.service.RatingSystem;

import java.util.List;

public class EmployeeController {
    private List<Employee> employees;
    private PaymentSystem paymentSystem;
    private RatingSystem ratingSystem;

    public EmployeeController(List<Employee> employees, PaymentSystem paymentSystem, RatingSystem ratingSystem) {
        this.employees = employees;
        this.paymentSystem = paymentSystem;
        this.ratingSystem = ratingSystem;
    }

    // CRUD operations
    public void registerEmployee(Employee employee) {
        employees.add(employee);
    }

    public void updateEmployee(Employee employee) {
        // Implementation for updating employee info
    }

    public void deleteEmployee(Employee employee) {
        employees.remove(employee);
    }

    // Job-related methods
    public void acceptJob(Employee employee, Job job) {
        employee.acceptJob(job);
    }

    public void updateJobStatus(Employee employee, Job job, JobStatus status) {
        employee.updateJobStatus(job, status);
    }

    // Ratings
    public void rateUser(Employee employee, Employee targetEmployee, double rating) {
        ratingSystem.rateEmployee(targetEmployee, rating);
    }

    public void calculatePay(Employee employee) {
        paymentSystem.calculatePay(employee);
    }

    // Utility
    public List<Employee> getAllEmployees() {
        return employees;
    }
}
