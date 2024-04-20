package tms.demo.repository;

public class PaymentRepository {
    // Singleton implementation for PaymentRepository
    private static PaymentRepository instance;

    private PaymentRepository() {
        // Private constructor to prevent instantiation from outside
    }

    public static PaymentRepository getInstance() {
        if (instance == null) {
            instance = new PaymentRepository();
        }
        return instance;
    }

    // Other fields and methods related to PaymentRepository class
}


// package tms.demo.repository;

// import java.util.HashMap;
// import java.util.Map;

// import tms.demo.model.Payment;

// public class PaymentRepository {
//     // Simulated storage for payments
//     private Map<Long, Payment> paymentStorage;

//     private static PaymentRepository instance;

//     private PaymentRepository() {
//         // Initialize the payment storage
//         paymentStorage = new HashMap<>();
//     }

//     public static PaymentRepository getInstance() {
//         if (instance == null) {
//             instance = new PaymentRepository();
//         }
//         return instance;
//     }

//     // Method to save a payment
//     public void savePayment(Payment payment) {
//         // Simulate storing payment data in the storage
//         paymentStorage.put(payment.getId(), payment);
//     }

//     // Method to retrieve a payment by ID
//     public Payment getPaymentById(Long id) {
//         // Simulate retrieving payment data from the storage
//         return paymentStorage.get(id);
//     }

//     // Method to update a payment
//     public void updatePayment(Payment payment) {
//         // Simulate updating payment data in the storage
//         paymentStorage.put(payment.getId(), payment);
//     }

//     // Method to delete a payment
//     public void deletePayment(Long id) {
//         // Simulate deleting payment data from the storage
//         paymentStorage.remove(id);
//     }
// }
