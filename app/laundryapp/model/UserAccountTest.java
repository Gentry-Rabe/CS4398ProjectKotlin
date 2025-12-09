package laundryapp.model;

import java.util.ArrayList;

public class UserAccountTest {

    public static void main(String[] args) {
        System.out.println("=== USER ACCOUNT TEST START ===");

        PaymentInfo paymentInfo = new PaymentInfo(
                "1234-5678-9012-3456",
                "12/27",
                "123"
        );

        UserAccount user = new UserAccount(
                1,
                "Test User",
                "test@example.com",
                "hashed_password",
                "Austin, TX",
                paymentInfo,
                new ArrayList<>()
        );

        System.out.println("User created:");
        System.out.println(user);

        Order order = new Order(
                101,
                "Laundry Order #1",
                24.99
        );

        user.addOrder(order);

        System.out.println("After adding one order:");
        System.out.println("Orders count = " + user.getOrders().size());

        System.out.println("=== USER ACCOUNT TEST COMPLETE ✅ ===");
    }
}
