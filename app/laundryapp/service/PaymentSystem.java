package app.controller;

import app.model.UserAccount;
import app.model.Employee;
import app.model.Order;
import app.model.JobStatus;

public class PaymentSystem {

    /**
     * Process a payment for an order:
     * 1. Withdraw money from the user.
     * 2. Deposit money into the employee's account.
     * 3. Mark the job as COMPLETED.
     */
    public void processPayment(UserAccount user, Employee employee, double amount) {
        if (user == null || employee == null) {
            System.out.println("Payment failed: User or Employee is null.");
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

        // Update order status
        Order order = findMatchingOrder(user, employee, amount);
        if (order != null) {
            order.setStatus(JobStatus.COMPLETED);
        }

        System.out.println("Payment of $" + amount + " processed successfully.");
    }


    /**
     * Issue a refund to a user:
     * 1. Add money back to the user's payment balance.
     * 2. Mark the order REFUNDED.
     */
    public void refundPayment(UserAccount user, double amount) {
        if (user == null || user.getPaymentInfo() == null) {
            System.out.println("Refund failed: Invalid user.");
            return;
        }

        // Refund to user's balance
        user.getPaymentInfo().refund(amount);

        // Update order status
        Order order = findOrderByAmount(user, amount);
        if (order != null) {
            order.setStatus(JobStatus.REFUNDED);
        }

        System.out.println("Refund of $" + amount + " issued successfully.");
    }


    /**
     * Calculate employee pay based on all COMPLETED jobs.
     */
    public void calculatePay(Employee employee) {
        if (employee == null) {
            System.out.println("Cannot calculate pay: Employee is null.");
            return;
        }

        double totalPay = 0.0;

        if (employee.getAssignedJobs() != null) {
            for (Order job : employee.getAssignedJobs()) {
                if (job.getStatus() == JobStatus.COMPLETED) {
                    totalPay += job.getCost();
                }
            }
        }

        System.out.println("Employee " + employee.getName() +
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

    private Order findMatchingOrder(UserAccount user, Employee employee, double amount) {
        if (user.getOrders() == null) return null;

        for (Order o : user.getOrders()) {
            if (o.getEmployee() != null &&
                o.getEmployee().equals(employee) &&
                o.getCost() == amount) {

                return o;
            }
        }
        return null;
    }

    private Order findOrderByAmount(UserAccount user, double amount) {
        if (user.getOrders() == null) return null;

        for (Order o : user.getOrders()) {
            if (o.getCost() == amount) {
                return o;
            }
        }
        return null;
    }
}
