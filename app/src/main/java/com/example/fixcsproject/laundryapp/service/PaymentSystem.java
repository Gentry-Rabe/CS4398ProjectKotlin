package com.example.fixcsproject.laundryapp.service;

import com.example.fixcsproject.laundryapp.model.UserAccount;
import com.example.fixcsproject.laundryapp.model.Employee;
import com.example.fixcsproject.laundryapp.model.JobStatus;
import com.example.fixcsproject.laundryapp.model.Job;

public class PaymentSystem {

    /**
     * Process a payment for a job:
     * 1. Withdraw money from the user.
     * 2. Deposit money into the employee's account.
     * 3. Mark the job as COMPLETED.
     */
    public void processPayment(UserAccount user, Employee employee, double amount) {
        if (user == null || employee == null) {
            System.out.println("Payment failed: User or com.example.fixcsproject.laundryapp.model.Employee is null.");
            return;
        }

        if (user.getPaymentInfo() == null) {
            System.out.println("Payment failed: User has no payment information.");
            return;
        }

        // Charge user
        boolean success = withdrawFromUser(user, amount);
        if (!success) {
            System.out.println("Payment failed: Insufficient funds.");
            return;
        }

        // Pay employee
        if (employee.getPaymentInfo() != null) {
            employee.getPaymentInfo().deposit(amount);
        }

        // Update job status
        Job job = findMatchingJob(user, employee, amount);
        if (job != null) {
            job.setStatus(JobStatus.COMPLETED);
        }

        System.out.println("Payment of $" + amount + " processed successfully.");
    }


    /**
     * Issue a refund to a user:
     * 1. Add money back to the user's payment balance.
     * 2. Mark the job REFUNDED.
     */
    public void refundPayment(UserAccount user, double amount) {
        if (user == null || user.getPaymentInfo() == null) {
            System.out.println("Refund failed: Invalid user.");
            return;
        }

        // Refund to user's balance
        user.getPaymentInfo().refund(amount);

        // Update job status
        Job job = findJobByAmount(user, amount);
        if (job != null) {
            job.setStatus(JobStatus.REFUNDED);
        }

        System.out.println("Refund of $" + amount + " issued successfully.");
    }


    /**
     * Calculate employee pay based on all COMPLETED jobs.
     */
    public void calculatePay(Employee employee) {
        if (employee == null) {
            System.out.println("Cannot calculate pay: com.example.fixcsproject.laundryapp.model.Employee is null.");
            return;
        }

        double totalPay = 0.0;

        if (employee.getAssignedJobs() != null) {
            for (Job job : employee.getAssignedJobs()) {
                if (job.getStatus() == JobStatus.COMPLETED) {
                    totalPay += job.getPrice();
                }
            }
        }

        System.out.println("com.example.fixcsproject.laundryapp.model.Employee " + employee.getName() +
                " has earned a total of $" + totalPay + " from completed jobs.");
    }


    // ============================================================
    // ========== INTERNAL HELPER METHODS ==========================
    // ============================================================

    private boolean withdrawFromUser(UserAccount user, double amount) {
        if (user.getPaymentInfo().getBalance() >= amount) {
            user.getPaymentInfo().withdraw(amount);
            return true;
        }
        return false;
    }

    private Job findMatchingJob(UserAccount user, Employee employee, double amount) {
        if (user.getJobs() == null) return null;

        for (Job j : user.getJobs()) {
            if (j.getEmployee() != null &&
                j.getEmployee().equals(employee) &&
                j.getPrice() == amount) {

                return j;
            }
        }
        return null;
    }

    private Job findJobByAmount(UserAccount user, double amount) {
        if (user.getJobs() == null) return null;

        for (Job j : user.getJobs()) {
            if (j.getPrice() == amount) {
                return j;
            }
        }
        return null;
    }
}
