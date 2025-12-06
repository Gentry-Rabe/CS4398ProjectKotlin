package com.example.fixcsproject;

import com.example.fixcsproject.laundryapp.model.Employee;
import com.example.fixcsproject.laundryapp.model.PaymentInfo;
import com.example.fixcsproject.laundryapp.model.UserAccount;
import com.example.fixcsproject.laundryapp.model.Job;
import com.example.fixcsproject.laundryapp.service.PaymentSystem;

import org.junit.Test;
import static org.junit.Assert.*;

public class PaymentSystemTest {

    @Test
    public void testProcessPaymentMovesMoneyCorrectly() {
        PaymentInfo userPay = new PaymentInfo("111", "BOA", "001", 500.0);
        PaymentInfo empPay = new PaymentInfo("222", "Chase", "002", 0.0);

        UserAccount user = new UserAccount(1, "John", "j@a.com", "pass", "Austin", userPay);
        Employee emp = new Employee(10, "Jane", "e@a.com", "pass");
        emp.setPayAccount(empPay);

        PaymentSystem paymentSystem = new PaymentSystem();

        paymentSystem.processPayment(user, emp, 200.0);

        assertEquals(300.0, user.getPaymentInfo().getBalance(), 0.001);
        assertEquals(200.0, emp.getPayAccount().getBalance(), 0.001);
    }

    @Test
    public void testRefundPaymentRestoresUserBalance() {
        PaymentInfo userPay = new PaymentInfo("111", "BOA", "001", 100.0);
        UserAccount user = new UserAccount(1, "John", "j@a.com", "pass", "Austin", userPay);

        PaymentSystem paymentSystem = new PaymentSystem();

        paymentSystem.refundPayment(user, 50.0);

        assertEquals(150.0, user.getPaymentInfo().getBalance(), 0.001);
    }
}
