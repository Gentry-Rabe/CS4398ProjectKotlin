package com.example.fixcsproject.laundryapp.controller;

import com.example.fixcsproject.laundryapp.model.Employee;
import com.example.fixcsproject.laundryapp.model.Job;
import com.example.fixcsproject.laundryapp.model.JobStatus;

import com.example.fixcsproject.laundryapp.service.PaymentSystem;
import com.laundryapp.service.RatingSystem;

import java.util.List;

public class EmployeeController {
    private List<com.example.fixcsproject.laundryapp.model.Employee> employees;
    private PaymentSystem paymentSystem;
    private RatingSystem ratingSystem;

    public EmployeeController(List<com.example.fixcsproject.laundryapp.model.Employee> employees, PaymentSystem paymentSystem, RatingSystem ratingSystem) {
        this.employees = employees;
        this.paymentSystem = paymentSystem;
        this.ratingSystem = ratingSystem;
    }

    // CRUD operations
    public void registerEmployee(Employee employee) {
        employees.add(employee);
    }

    public void updateEmployee(com.example.fixcsproject.laundryapp.model.Employee employee) {
        // Implementation for updating employee info
    }

    public void deleteEmployee(com.example.fixcsproject.laundryapp.model.Employee employee) {
        employees.remove(employee);
    }

    // com.example.fixcsproject.laundryapp.model.Job-related methods
    public void acceptJob(com.example.fixcsproject.laundryapp.model.Employee employee, Job job) {
        employee.acceptJob(job);
    }

    public void updateJobStatus(com.example.fixcsproject.laundryapp.model.Employee employee, Job job, JobStatus status) {
        employee.updateJobStatus(job, status);
    }

    // Ratings
    public void rateUser(com.example.fixcsproject.laundryapp.model.Employee employee, com.example.fixcsproject.laundryapp.model.Employee targetEmployee, double rating) {
        ratingSystem.rateEmployee(targetEmployee, rating);
    }

    public void calculatePay(com.example.fixcsproject.laundryapp.model.Employee employee) {
        paymentSystem.calculatePay(employee);
    }

    // Utility
    public List<com.example.fixcsproject.laundryapp.model.Employee> getAllEmployees() {
        return employees;
    }
}
